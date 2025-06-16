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
import modelo.TelaCadastroCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastroClienteDAO {
    public TelaCadastroClienteDAO() {
        // Conexão será gerenciada em cada método
    }

    public void adicionar(TelaCadastroCliente telacadastrocliente) {
        String sql = "INSERT INTO telacadastroclientes (nome, cpf, telefone, email, numero, tipo, status, valor_diaria, data_checkin, data_checkout, data_pagamento, valor_total, metodo_pagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, telacadastrocliente.getNome());
            stmt.setString(2, telacadastrocliente.getCpf());
            stmt.setString(3, telacadastrocliente.getTelefone());
            stmt.setString(4, telacadastrocliente.getEmail());
            stmt.setString(5, telacadastrocliente.getNumero());
            stmt.setString(6, telacadastrocliente.getTipo());
            stmt.setString(7, telacadastrocliente.getStatus());
            stmt.setDouble(8, Double.parseDouble(telacadastrocliente.getValor_Diaria()));
            stmt.setDate(9, telacadastrocliente.getData_Checkin().isEmpty() ? null : java.sql.Date.valueOf(telacadastrocliente.getData_Checkin()));
            stmt.setDate(10, telacadastrocliente.getData_Checkout().isEmpty() ? null : java.sql.Date.valueOf(telacadastrocliente.getData_Checkout()));
            stmt.setDate(11, telacadastrocliente.getData_Pagamento().isEmpty() ? null : java.sql.Date.valueOf(telacadastrocliente.getData_Pagamento()));
            stmt.setDouble(12, Double.parseDouble(telacadastrocliente.getValor_Total()));
            stmt.setString(13, telacadastrocliente.getMetodo_Pagamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar cliente: " + e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Erro ao converter valores numéricos: " + e.getMessage(), e);
        }
    }

    public void atualizar(TelaCadastroCliente telacadastrocliente) {
        String sql = "UPDATE telacadastroclientes SET nome = ?, cpf = ?, telefone = ?, email = ?, numero = ?, tipo = ?, status = ?, valor_diaria = ?, data_checkin = ?, data_checkout = ?, data_pagamento = ?, valor_total = ?, metodo_pagamento = ? WHERE id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, telacadastrocliente.getNome());
            stmt.setString(2, telacadastrocliente.getCpf());
            stmt.setString(3, telacadastrocliente.getTelefone());
            stmt.setString(4, telacadastrocliente.getEmail());
            stmt.setString(5, telacadastrocliente.getNumero());
            stmt.setString(6, telacadastrocliente.getTipo());
            stmt.setString(7, telacadastrocliente.getStatus());
            stmt.setDouble(8, Double.parseDouble(telacadastrocliente.getValor_Diaria()));
            stmt.setDate(9, telacadastrocliente.getData_Checkin().isEmpty() ? null : java.sql.Date.valueOf(telacadastrocliente.getData_Checkin()));
            stmt.setDate(10, telacadastrocliente.getData_Checkout().isEmpty() ? null : java.sql.Date.valueOf(telacadastrocliente.getData_Checkout()));
            stmt.setDate(11, telacadastrocliente.getData_Pagamento().isEmpty() ? null : java.sql.Date.valueOf(telacadastrocliente.getData_Pagamento()));
            stmt.setDouble(12, Double.parseDouble(telacadastrocliente.getValor_Total()));
            stmt.setString(13, telacadastrocliente.getMetodo_Pagamento());
            stmt.setInt(14, telacadastrocliente.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Cliente com ID " + telacadastrocliente.getId() + " não encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Erro ao converter valores numéricos: " + e.getMessage(), e);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM telacadastroclientes WHERE id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Cliente com ID " + id + " não encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente: " + e.getMessage(), e);
        }
    }

    public List<TelaCadastroCliente> listar() {
        List<TelaCadastroCliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM telacadastroclientes";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TelaCadastroCliente cliente = new TelaCadastroCliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone") != null ? rs.getString("telefone") : "",
                    rs.getString("email") != null ? rs.getString("email") : "",
                    rs.getString("numero"),
                    rs.getString("tipo") != null ? rs.getString("tipo") : "",
                    rs.getString("status") != null ? rs.getString("status") : "",
                    String.valueOf(rs.getDouble("valor_diaria")),
                    rs.getDate("data_checkin") != null ? rs.getDate("data_checkin").toString() : "",
                    rs.getDate("data_checkout") != null ? rs.getDate("data_checkout").toString() : "",
                    rs.getDate("data_pagamento") != null ? rs.getDate("data_pagamento").toString() : "",
                    String.valueOf(rs.getDouble("valor_total")),
                    rs.getString("metodo_pagamento") != null ? rs.getString("metodo_pagamento") : ""
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage(), e);
        }
        return clientes;
    }

    public TelaCadastroCliente buscarPorId(int id) {
        String sql = "SELECT * FROM telacadastroclientes WHERE id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TelaCadastroCliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone") != null ? rs.getString("telefone") : "",
                        rs.getString("email") != null ? rs.getString("email") : "",
                        rs.getString("numero"),
                        rs.getString("tipo") != null ? rs.getString("tipo") : "",
                        rs.getString("status") != null ? rs.getString("status") : "",
                        String.valueOf(rs.getDouble("valor_diaria")),
                        rs.getDate("data_checkin") != null ? rs.getDate("data_checkin").toString() : "",
                        rs.getDate("data_checkout") != null ? rs.getDate("data_checkout").toString() : "",
                        rs.getDate("data_pagamento") != null ? rs.getDate("data_pagamento").toString() : "",
                        String.valueOf(rs.getDouble("valor_total")),
                        rs.getString("metodo_pagamento") != null ? rs.getString("metodo_pagamento") : ""
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente: " + e.getMessage(), e);
        }
        return null;
    }
}