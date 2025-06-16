/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author HP
 */
public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost/sistema-de-reserva-de-hoteis";
    private static final String USER = "root"; 
    private static final String PASSWORD = "173385"; // Confirme se essa é a senha correta //usbw

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + excecao.getMessage(), excecao);
        }
    }
}
