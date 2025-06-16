package dao;
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
        String sql = "INSERT INTO telacadastrofuncionarios (nome, cpf, telefone, data_nascimento, rua, numero, bairro, cidade, cargo, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            stmt.setString(9, funcionario.getCargo());
            stmt.setString(10, funcionario.getLogin());
            stmt.setString(11, funcionario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar funcionário: " + e.getMessage(), e);
        }
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE telacadastrofuncionarios SET nome = ?, cpf = ?, cargo =?, login=?, senha=?, telefone = ?, data_nascimento = ?, rua = ?, numero = ?, bairro = ?, cidade = ? WHERE id = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getLogin());
            stmt.setString(5, funcionario.getSenha());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setDate(7, funcionario.getData_nascimento().isEmpty() ? null : java.sql.Date.valueOf(funcionario.getData_nascimento()));
            stmt.setString(8, funcionario.getRua());
            stmt.setString(9, funcionario.getNumero());
            stmt.setString(10, funcionario.getBairro());
            stmt.setString(11, funcionario.getCidade());
            stmt.setInt(12, funcionario.getId());
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
                    rs.getString("cargo"),
                    rs.getString("login"),
                    rs.getString("senha"),
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