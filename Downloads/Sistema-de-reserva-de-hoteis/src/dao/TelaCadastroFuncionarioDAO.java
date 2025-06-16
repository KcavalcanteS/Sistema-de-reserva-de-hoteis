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
import modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastroFuncionarioDAO {
    public void adicionar(Funcionario funcionario) {
        String sql = "INSERT INTO telacadastrofuncionarios (nome, cpf, telefone, data_nascimento, rua, numero, bairro, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setDate(4, funcionario.getData_nascimento().isEmpty() ? null : java.sql.Date.valueOf(funcionario.getData_nascimento()));
            stmt.setString(5, funcionario.getRua());
            stmt.setString(6, funcionario.getNumero());
            stmt.setString(7, funcionario.getBairro());
            stmt.setString(8, funcionario.getCidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar funcionário: " + e.getMessage(), e);
        }
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE telacadastrofuncionarios SET nome = ?, cpf = ?, telefone = ?, data_nascimento = ?, rua = ?, numero = ?, bairro = ?, cidade = ? WHERE id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setDate(4, funcionario.getData_nascimento().isEmpty() ? null : java.sql.Date.valueOf(funcionario.getData_nascimento()));
            stmt.setString(5, funcionario.getRua());
            stmt.setString(6, funcionario.getNumero());
            stmt.setString(7, funcionario.getBairro());
            stmt.setString(8, funcionario.getCidade());
            stmt.setInt(9, funcionario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage(), e);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM telacadastrofuncionarios WHERE id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir funcionário: " + e.getMessage(), e);
        }
    }

    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM telacadastrofuncionarios";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone") != null ? rs.getString("telefone") : "",
                    rs.getDate("data_nascimento") != null ? rs.getDate("data_nascimento").toString() : "",
                    rs.getString("rua") != null ? rs.getString("rua") : "",
                    rs.getString("numero") != null ? rs.getString("numero") : "",
                    rs.getString("bairro") != null ? rs.getString("bairro") : "",
                    rs.getString("cidade") != null ? rs.getString("cidade") : ""
                );
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar funcionários: " + e.getMessage(), e);
        }
        return funcionarios;
    }
}