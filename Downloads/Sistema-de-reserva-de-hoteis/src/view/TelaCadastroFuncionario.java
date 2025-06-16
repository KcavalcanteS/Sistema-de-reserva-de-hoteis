/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author HP
 */


import dao.TelaCadastroFuncionarioDAO;
import modelo.Funcionario;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TelaCadastroFuncionario extends JFrame {
    private JTextField txtNome, txtCpf, txtTelefone, txtDataNascimento, txtRua, txtNumero, txtBairro, txtCidade, txtBuscarNome;
    private JButton btnCadastrar, btnBuscar, btnAlterar, btnExcluir, btnSalvarAlteracoes, btnCancelar;
    private Funcionario funcionarioSelecionado;

    public TelaCadastroFuncionario() {
        setTitle("Cadastro de Funcionário");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        // Painel principal com barra de título
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(0, 128, 0)); // Verde
        JLabel titleLabel = new JLabel("Cadastro de Funcionário", SwingConstants.CENTER);
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
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel lblNome = new JLabel("Nome:*");
        lblNome.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblNome, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        txtNome = new JTextField(20);
        fieldsPanel.add(txtNome, gbc);

        // Linha 2: CPF
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblCpf = new JLabel("CPF:*");
        lblCpf.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblCpf, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        txtCpf = new JTextField(20);
        fieldsPanel.add(txtCpf, gbc);

        // Linha 3: Telefone
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblTelefone, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        txtTelefone = new JTextField(20);
        fieldsPanel.add(txtTelefone, gbc);

        // Linha 4: Data Nascimento
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel lblDataNascimento = new JLabel("Data Nascimento (dd/mm/aaaa):");
        lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblDataNascimento, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        txtDataNascimento = new JTextField(20);
        fieldsPanel.add(txtDataNascimento, gbc);

        // Linha 5: Rua
        gbc.gridx = 0; gbc.gridy = 5;
        JLabel lblRua = new JLabel("Rua:");
        lblRua.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblRua, gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        txtRua = new JTextField(20);
        fieldsPanel.add(txtRua, gbc);

        // Linha 6: Número
        gbc.gridx = 0; gbc.gridy = 6;
        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblNumero, gbc);

        gbc.gridx = 1; gbc.gridy = 6;
        txtNumero = new JTextField(20);
        fieldsPanel.add(txtNumero, gbc);

        // Linha 7: Bairro
        gbc.gridx = 0; gbc.gridy = 7;
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblBairro, gbc);

        gbc.gridx = 1; gbc.gridy = 7;
        txtBairro = new JTextField(20);
        fieldsPanel.add(txtBairro, gbc);

        // Linha 8: Cidade
        gbc.gridx = 0; gbc.gridy = 8;
        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblCidade, gbc);

        gbc.gridx = 1; gbc.gridy = 8;
        txtCidade = new JTextField(20);
        fieldsPanel.add(txtCidade, gbc);

        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(fieldsPanel, BorderLayout.CENTER);

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
        buttonPanel.add(btnAlterar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnBuscar);
        buttonPanel.add(btnSalvarAlteracoes);
        buttonPanel.add(btnCancelar);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(e -> cadastrarFuncionario());
        btnBuscar.addActionListener(e -> buscarFuncionario());
        btnAlterar.addActionListener(e -> alterarFuncionario());
        btnExcluir.addActionListener(e -> excluirFuncionario());
        btnSalvarAlteracoes.addActionListener(e -> salvarAlteracoes());
        btnCancelar.addActionListener(e -> {
            limparCampos();
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvarAlteracoes.setVisible(false);
            funcionarioSelecionado = null;
        });

        add(mainPanel);
        setVisible(true);
    }

    private void cadastrarFuncionario() {
        if (!validarCamposObrigatorios()) return;

        try {
            String nome = txtNome.getText().trim();
            String cpf = txtCpf.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String dataNascimento = txtDataNascimento.getText().trim();
            String rua = txtRua.getText().trim();
            String numero = txtNumero.getText().trim();
            String bairro = txtBairro.getText().trim();
            String cidade = txtCidade.getText().trim();

            SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
            sdfInput.setLenient(false);
            String dataNascimentoConverted = dataNascimento.isEmpty() ? "" : sdfOutput.format(sdfInput.parse(dataNascimento));

            Funcionario funcionario = new Funcionario(0, nome, cpf, telefone, dataNascimentoConverted,
                    rua, numero, bairro, cidade);
            TelaCadastroFuncionarioDAO dao = new TelaCadastroFuncionarioDAO();
            dao.adicionar(funcionario);

            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            limparCampos();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro na data! Use o formato dd/mm/aaaa.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void buscarFuncionario() {
        String nomeBusca = txtBuscarNome.getText().trim();
        if (nomeBusca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um nome para buscar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TelaCadastroFuncionarioDAO dao = new TelaCadastroFuncionarioDAO();
        List<Funcionario> funcionarios = dao.listar();
        funcionarioSelecionado = null;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nomeBusca)) {
                funcionarioSelecionado = funcionario;
                break;
            }
        }

        if (funcionarioSelecionado != null) {
            txtNome.setText(funcionarioSelecionado.getNome());
            txtCpf.setText(funcionarioSelecionado.getCpf());
            txtTelefone.setText(funcionarioSelecionado.getTelefone());
            txtDataNascimento.setText(formatarData(funcionarioSelecionado.getData_nascimento()));
            txtRua.setText(funcionarioSelecionado.getRua());
            txtNumero.setText(funcionarioSelecionado.getNumero());
            txtBairro.setText(funcionarioSelecionado.getBairro());
            txtCidade.setText(funcionarioSelecionado.getCidade());
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            limparCampos();
        }
    }

    private void alterarFuncionario() {
        if (funcionarioSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Busque um funcionário antes de alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        btnCadastrar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnSalvarAlteracoes.setVisible(true);
    }

    private void salvarAlteracoes() {
        if (!validarCamposObrigatorios()) return;

        if (funcionarioSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário selecionado para alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String nome = txtNome.getText().trim();
            String cpf = txtCpf.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String dataNascimento = txtDataNascimento.getText().trim();
            String rua = txtRua.getText().trim();
            String numero = txtNumero.getText().trim();
            String bairro = txtBairro.getText().trim();
            String cidade = txtCidade.getText().trim();

            SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
            sdfInput.setLenient(false);
            String dataNascimentoConverted = dataNascimento.isEmpty() ? "" : sdfOutput.format(sdfInput.parse(dataNascimento));

            funcionarioSelecionado.setNome(nome);
            funcionarioSelecionado.setCpf(cpf);
            funcionarioSelecionado.setTelefone(telefone);
            funcionarioSelecionado.setData_nascimento(dataNascimentoConverted);
            funcionarioSelecionado.setRua(rua);
            funcionarioSelecionado.setNumero(numero);
            funcionarioSelecionado.setBairro(bairro);
            funcionarioSelecionado.setCidade(cidade);

            TelaCadastroFuncionarioDAO dao = new TelaCadastroFuncionarioDAO();
            dao.atualizar(funcionarioSelecionado);
            JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
            limparCampos();
            btnSalvarAlteracoes.setVisible(false);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            funcionarioSelecionado = null;
            btnCadastrar.setEnabled(true);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro na data! Use o formato dd/mm/aaaa.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void excluirFuncionario() {
        if (funcionarioSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Busque um funcionário antes de excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o funcionário " + funcionarioSelecionado.getNome() + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                TelaCadastroFuncionarioDAO dao = new TelaCadastroFuncionarioDAO();
                dao.excluir(funcionarioSelecionado.getId());
                JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
                limparCampos();
                btnAlterar.setEnabled(false);
                btnExcluir.setEnabled(false);
                funcionarioSelecionado = null;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtDataNascimento.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtBuscarNome.setText("");
        resetCampoObrigatorio();
    }

    private String formatarData(String data) {
        if (data == null || data.isEmpty()) return "";
        try {
            SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfOutput = new SimpleDateFormat("dd/MM/yyyy");
            return sdfOutput.format(sdfInput.parse(data));
        } catch (Exception e) {
            return data;
        }
    }

    private double parseDoubleOrZero(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private boolean validarCamposObrigatorios() {
        boolean isValid = true;
        if (txtNome.getText().trim().isEmpty()) {
            txtNome.setBackground(new Color(255, 182, 193));
            isValid = false;
        } else {
            txtNome.setBackground(Color.WHITE);
        }
        if (txtCpf.getText().trim().isEmpty()) {
            txtCpf.setBackground(new Color(255, 182, 193));
            isValid = false;
        } else {
            txtCpf.setBackground(Color.WHITE);
        }
        if (!isValid) {
            JOptionPane.showMessageDialog(null, "Os campos com * são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }

    private void resetCampoObrigatorio() {
        txtNome.setBackground(Color.WHITE);
        txtCpf.setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroFuncionario().setVisible(true));
    }
}