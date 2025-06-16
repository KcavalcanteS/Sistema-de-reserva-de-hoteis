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
import java.util.List;

public class TelaCadastroUsuario extends JFrame {
    private JTextField txtNome, txtCargo, txtUsername, txtBuscarNome;
    private JPasswordField txtSenha;
    private JButton btnCadastrar, btnBuscar, btnAlterar, btnExcluir, btnSalvarAlteracoes, btnCancelar;
    private TelaLoginDAO.Usuario usuarioSelecionado; // Usando a classe do DAO

    public TelaCadastroUsuario() {
        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(550, 350);
        setLocationRelativeTo(null);

        // Painel principal com barra de título
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(0, 128, 0)); // Verde
        JLabel titleLabel = new JLabel("Cadastro de Usuário", SwingConstants.CENTER);
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

        // Linha 0: Buscar por Nome
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblBuscarNome = new JLabel("Buscar por Nome:*");
        lblBuscarNome.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblBuscarNome, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        txtBuscarNome = new JTextField(20);
        fieldsPanel.add(txtBuscarNome, gbc);

        // Linha 1: Nome
        /*
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel lblNome = new JLabel("Nome:*");
        lblNome.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblNome, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        txtNome = new JTextField(20);
        fieldsPanel.add(txtNome, gbc);
        */
        // Linha 2: Cargo
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblCargo = new JLabel("Cargo:*");
        lblCargo.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblCargo, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        txtCargo = new JTextField(20);
        fieldsPanel.add(txtCargo, gbc);

        // Linha 3: Username
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel lblUsername = new JLabel("Username:*");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblUsername, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        txtUsername = new JTextField(20);
        fieldsPanel.add(txtUsername, gbc);

        // Linha 4: Senha
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel lblSenha = new JLabel("Senha:*");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblSenha, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        txtSenha = new JPasswordField(20);
        fieldsPanel.add(txtSenha, gbc);

        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(fieldsPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(211, 211, 211));

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(220, 220, 220)); // Cinza claro
        btnCadastrar.setForeground(Color.BLACK);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
        btnCadastrar.setFocusPainted(false);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(220, 220, 220)); // Cinza claro
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 12));
        btnBuscar.setFocusPainted(false);

        btnAlterar = new JButton("Alterar");
        btnAlterar.setBackground(new Color(220, 220, 220)); // Cinza claro
        btnAlterar.setForeground(Color.BLACK);
        btnAlterar.setFont(new Font("Arial", Font.BOLD, 12));
        btnAlterar.setEnabled(false);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBackground(new Color(220, 220, 220)); // Cinza claro
        btnExcluir.setForeground(Color.BLACK);
        btnExcluir.setFont(new Font("Arial", Font.BOLD, 12));
        btnExcluir.setEnabled(false);

        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        btnSalvarAlteracoes.setBackground(new Color(220, 220, 220)); // Cinza claro
        btnSalvarAlteracoes.setForeground(Color.BLACK);
        btnSalvarAlteracoes.setFont(new Font("Arial", Font.BOLD, 12));
        btnSalvarAlteracoes.setFocusPainted(false);
        btnSalvarAlteracoes.setVisible(false);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(220, 220, 220)); // Cinza claro
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 12));
        btnCancelar.setFocusPainted(false);

        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnAlterar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnSalvarAlteracoes);
        buttonPanel.add(btnCancelar);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ações dos botões
        btnCadastrar.addActionListener(e -> cadastrarUsuario());
        btnBuscar.addActionListener(e -> buscarUsuario());
        btnAlterar.addActionListener(e -> alterarUsuario());
        btnExcluir.addActionListener(e -> excluirUsuario());
        btnSalvarAlteracoes.addActionListener(e -> salvarAlteracoes());
        btnCancelar.addActionListener(e -> {
            limparCampos();
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvarAlteracoes.setVisible(false);
            usuarioSelecionado = null;
            setVisible(false);
        });

        add(mainPanel);
        setVisible(true);
    }

    private void cadastrarUsuario() {
        if (!validarCamposObrigatorios()) return;

        try {
            String nome = txtNome.getText().trim();
            String cargo = txtCargo.getText().trim();
            String username = txtUsername.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();

            TelaLoginDAO dao = new TelaLoginDAO();
            dao.adicionar(nome, cargo, username, senha);

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void buscarUsuario() {
        String nomeBusca = txtBuscarNome.getText().trim();
        if (nomeBusca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um nome para buscar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TelaLoginDAO dao = new TelaLoginDAO();
        List<TelaLoginDAO.Usuario> usuarios = dao.listar();
        usuarioSelecionado = null;

        for (TelaLoginDAO.Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeBusca)) {
                usuarioSelecionado = usuario;
                break;
            }
        }

        if (usuarioSelecionado != null) {
            txtNome.setText(usuarioSelecionado.getNome());
            txtCargo.setText(usuarioSelecionado.getCargo());
            txtUsername.setText(usuarioSelecionado.getUsername());
            txtSenha.setText(usuarioSelecionado.getSenha()); // Nota: Exibe senha em texto puro
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            limparCampos();
        }
    }

    private void alterarUsuario() {
        if (usuarioSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Busque um usuário antes de alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        btnCadastrar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnSalvarAlteracoes.setVisible(true);
    }

    private void salvarAlteracoes() {
        if (!validarCamposObrigatorios()) return;

        if (usuarioSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário selecionado para alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String nome = txtNome.getText().trim();
            String cargo = txtCargo.getText().trim();
            String username = txtUsername.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();

            TelaLoginDAO dao = new TelaLoginDAO();
            dao.atualizar(usuarioSelecionado.getId(), nome, cargo, username, senha);

            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            limparCampos();
            btnSalvarAlteracoes.setVisible(false);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            usuarioSelecionado = null;
            btnCadastrar.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void excluirUsuario() {
        if (usuarioSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Busque um usuário antes de excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o usuário " + usuarioSelecionado.getNome() + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                TelaLoginDAO dao = new TelaLoginDAO();
                dao.excluir(usuarioSelecionado.getId());
                JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                limparCampos();
                btnAlterar.setEnabled(false);
                btnExcluir.setEnabled(false);
                usuarioSelecionado = null;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCargo.setText("");
        txtUsername.setText("");
        txtSenha.setText("");
        txtBuscarNome.setText("");
        resetCampoObrigatorio();
    }

    private boolean validarCamposObrigatorios() {
        boolean isValid = true;
        if (txtNome.getText().trim().isEmpty()) {
            txtNome.setBackground(new Color(255, 182, 193));
            isValid = false;
        } else {
            txtNome.setBackground(Color.WHITE);
        }
        if (txtCargo.getText().trim().isEmpty()) {
            txtCargo.setBackground(new Color(255, 182, 193));
            isValid = false;
        } else {
            txtCargo.setBackground(Color.WHITE);
        }
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

    private void resetCampoObrigatorio() {
        txtNome.setBackground(Color.WHITE);
        txtCargo.setBackground(Color.WHITE);
        txtUsername.setBackground(Color.WHITE);
        txtSenha.setBackground(Color.WHITE);
    }
    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroUsuario());
    }
    */
}