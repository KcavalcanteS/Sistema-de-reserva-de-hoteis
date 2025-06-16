/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author HP
 */
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaLoginDAO {
    public TelaLoginDAO() {
        // Conexão será gerenciada nos métodos
    }

    public boolean autenticar(String username, String senha) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND senha = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true se houver um registro
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao autenticar usuário: " + e.getMessage(), e);
        }
    }

    public void adicionar(String nome, String cargo, String username, String senha) {
        String sql = "INSERT INTO usuarios (nome, cargo, username, senha) VALUES (?, ?, ?, ?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nome);
            stmt.setString(2, cargo);
            stmt.setString(3, username);
            stmt.setString(4, senha);
            stmt.executeUpdate();

            // Opcional: Recuperar o ID gerado, se necessário
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    // ID pode ser usado se necessário
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário: " + e.getMessage(), e);
        }
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cargo"),
                    rs.getString("username"),
                    rs.getString("senha")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários: " + e.getMessage(), e);
        }
        return usuarios;
    }

    public void atualizar(int id, String nome, String cargo, String username, String senha) {
        String sql = "UPDATE usuarios SET nome = ?, cargo = ?, username = ?, senha = ? WHERE id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cargo);
            stmt.setString(3, username);
            stmt.setString(4, senha);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário: " + e.getMessage(), e);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir usuário: " + e.getMessage(), e);
        }
    }

    // Classe interna para representar o usuário
    public static class Usuario {
        private int id;
        private String nome, cargo, username, senha;

        public Usuario(int id, String nome, String cargo, String username, String senha) {
            this.id = id;
            this.nome = nome;
            this.cargo = cargo;
            this.username = username;
            this.senha = senha;
        }

        public int getId() { return id; }
        public String getNome() { return nome; }
        public String getCargo() { return cargo; }
        public String getUsername() { return username; }
        public String getSenha() { return senha; }
    }
}