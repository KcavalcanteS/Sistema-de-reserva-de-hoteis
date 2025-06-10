package Dao;
import ConexaoBD.ConexaoAuroraPH;
import Models.Clientes;
import java.sql.*;
import java.sql.PreparedStatement;
public class ClienteDAO {
    private Connection connection;
    String id_cliente;
    String telefone;
    String email;
    String cpf;
}
