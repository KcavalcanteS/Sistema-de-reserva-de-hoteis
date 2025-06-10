package Dao;
import ConexaoBD.ConexaoAuroraPH;
import Models.Clientes;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
public class ClienteDAO {
    private Connection connection;
    int id_cliente;
    String nome;
    String email;
    String cpf;
    String telefone;
    
    public Object cliente;
    
    public ClienteDAO(){
        this.connection = new ConexaoAuroraPH().getConnection();
    }
    //adicionar as informações do cliente ao banco de dados
    public void addCliente(Clientes cliente){
            String sql = "INSERT INTO Cliente(Nome, Email, CPF, Telefone)"
                    + "VALUES(?,?,?,?)";
            try {
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, cliente.getNome());
                    stmt.setString(2, cliente.getEmail());
                    stmt.setString(3, cliente.getCpf());
                    stmt.setString(4, cliente.getTelefone());
                    stmt.execute();
                }
            }
            catch(SQLException e){
            throw new RuntimeException(e);
            }
        }
    //listar todos os clientes
    public ArrayList<Clientes> getAllClientes() {
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente");
            while (resultSet.next()) {
                Clientes clienteO = new Clientes();
                clienteO.setId_cliente(resultSet.getInt("id"));
                clienteO.setNome(resultSet.getString("nome"));
                clienteO.setEmail(resultSet.getString("email"));
                clienteO.setCpf(resultSet.getString("cpf"));
                clienteO.setTelefone(resultSet.getString("telefone"));
                listaClientes.add(clienteO);
            }
        }
        catch (SQLException e) {
        throw new RuntimeException(e);
        }
        return listaClientes;
    }
    //listar cliente por id
    public Clientes getClientePorID(int id) {
        Clientes clienteO = new Clientes();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Cliente WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                clienteO.setId_cliente(resultSet.getInt("id"));
                clienteO.setNome(resultSet.getString("nome"));
                clienteO.setEmail(resultSet.getString("email"));
                clienteO.setCpf(resultSet.getString("cpf"));
                clienteO.setTelefone(resultSet.getString("telefone"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clienteO;
    }
    //editar informações do cliente por id
    public void updateCliente(Clientes cliente) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Cliente SET Nome=?, Email=?, CPF=?, TELEFONE=? WHERE id=?");
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3,cliente.getCpf());
            preparedStatement.setString(4,cliente.getTelefone());
            preparedStatement.setInt(5, cliente.getId_cliente());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //deletar cliente por id
    public void deleteUser(Clientes cliente) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Cliente WHERE id=?");
            preparedStatement.setInt(1, cliente.getId_cliente());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

