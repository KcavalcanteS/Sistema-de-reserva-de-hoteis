/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
package view;

import javax.swing.*;
import java.awt.*;

public class TelaMenuPrincipal extends JFrame {
    public TelaMenuPrincipal() {
        setTitle("Menu Principal - Sistema de Reserva de Hotéis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Criar e configurar a barra de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenu menuSair = new JMenu("Sair");

        // Itens do menu Cadastrar
        JMenuItem menuItemCadastrarFuncionario = new JMenuItem("Cadastrar Funcionário");
        JMenuItem menuItemCadastrarCliente = new JMenuItem("Cadastrar Cliente");
        menuCadastrar.add(menuItemCadastrarFuncionario);
        menuCadastrar.add(menuItemCadastrarCliente);

        // Item do menu Sair
        JMenuItem menuItemSair = new JMenuItem("Sair");
        menuSair.add(menuItemSair);

        // Adicionar menus à barra
        menuBar.add(menuCadastrar);
        menuBar.add(menuSair);
        setJMenuBar(menuBar);

        // Ação do item Cadastrar Funcionário
        menuItemCadastrarFuncionario.addActionListener(e -> {
            try {
                System.out.println("Abrindo TelaCadastrarFuncionario...");
                new TelaCadastroFuncionario();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir tela de cadastro de funcionário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        // Ação do item Cadastrar Usuário
        menuItemCadastrarCliente.addActionListener(e -> {
            try {
                System.out.println("Abrindo TelaCadastrarUsuario...");
                new TelaCadastrarCliente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir tela de cadastro de cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        // Ação do item Sair com confirmação
        menuItemSair.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                dispose();
                System.exit(0);
            }
        });

        // Painel principal com fundo azul claro
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230)); // Fundo azul claro

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaMenuPrincipal());
    }
}