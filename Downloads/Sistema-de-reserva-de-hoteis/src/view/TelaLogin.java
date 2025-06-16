/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author HP
 */

import dao.TelaLoginDAO;
import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtSenha;
    private JButton btnLogin, btnCadastrar;

    public TelaLogin() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Painel principal com barra de título
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(0, 128, 0)); // Verde
        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(211, 211, 211)); // Cinza claro
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        fieldsPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Linha 0: Username
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblUsername = new JLabel("Username:*");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblUsername, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        txtUsername = new JTextField(20);
        fieldsPanel.add(txtUsername, gbc);

        // Linha 1: Senha
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel lblSenha = new JLabel("Senha:*");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblSenha, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        txtSenha = new JPasswordField(20);
        fieldsPanel.add(txtSenha, gbc);

        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(fieldsPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(211, 211, 211));

        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(220, 220, 220)); // Cinza claro
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 12));
        btnLogin.setFocusPainted(false);
        /*
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(220, 220, 220)); // Cinza claro
        btnCadastrar.setForeground(Color.BLACK);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
        btnCadastrar.setFocusPainted(false);
        */
        buttonPanel.add(btnLogin);
        /*
        buttonPanel.add(btnCadastrar);
        */
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ações dos botões
        btnLogin.addActionListener(e -> autenticar());
        /*
        btnCadastrar.addActionListener(e -> {
            new TelaCadastroUsuario().setVisible(true); // Abre a tela de cadastro
        });
        */
        add(mainPanel);
        setVisible(true);
    }

    private void autenticar() {
        if (!validarCamposObrigatorios()) return;

        try {
            String username = txtUsername.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();

            TelaLoginDAO dao = new TelaLoginDAO();
            if (dao.autenticar(username, senha)) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                new TelaMenuPrincipal().setVisible(true); // Abre a tela principal
                dispose(); // Fecha a tela de login
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private boolean validarCamposObrigatorios() {
        boolean isValid = true;
        if (txtUsername.getText().trim().isEmpty()) {
            txtUsername.setBackground(new Color(255, 182, 193));
            isValid = false;
        } else {
            txtUsername.setBackground(Color.WHITE);
        }
        if (new String(txtSenha.getPassword()).trim().isEmpty()) {
            txtSenha.setBackground(new Color(255, 182, 193));
            isValid = false;
        } else {
            txtSenha.setBackground(Color.WHITE);
        }
        if (!isValid) {
            JOptionPane.showMessageDialog(null, "Os campos com * são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin());
    }
}