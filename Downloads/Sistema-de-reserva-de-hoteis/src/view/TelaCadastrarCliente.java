/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author HP
 */

import dao.TelaCadastroClienteDAO;
import modelo.TelaCadastroCliente;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TelaCadastrarCliente extends JFrame {
    private JTextField txtNome, txtCpf, txtTelefone, txtEmail, txtNumero, txtTipo, txtStatus, txtValorDiaria,
                       txtDataCheckin, txtDataCheckout, txtDataPagamento, txtValorTotal, txtMetodoPagamento, txtBuscarNome;
    private JButton btnCadastrar, btnBuscar, btnAlterar, btnExcluir, btnSalvarAlteracoes, btnCancelar;
    private TelaCadastroCliente clienteSelecionado; // Para armazenar o cliente encontrado

    public TelaCadastrarCliente() {
        setTitle("Cadastro de Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 700); // Ajustado para acomodar todos os campos
        setLocationRelativeTo(null);

        // Painel principal com barra de título
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(0, 128, 0)); // Verde
        JLabel titleLabel = new JLabel("Cadastro de Cliente", SwingConstants.CENTER);
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

        // Linha 4: Email
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblEmail, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        txtEmail = new JTextField(20);
        fieldsPanel.add(txtEmail, gbc);

        // Linha 5: Número do Quarto
        gbc.gridx = 0; gbc.gridy = 5;
        JLabel lblNumero = new JLabel("Número do Quarto:*");
        lblNumero.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblNumero, gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        txtNumero = new JTextField(20);
        fieldsPanel.add(txtNumero, gbc);

        // Linha 6: Tipo do Quarto
        gbc.gridx = 0; gbc.gridy = 6;
        JLabel lblTipo = new JLabel("Tipo do Quarto:");
        lblTipo.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblTipo, gbc);

        gbc.gridx = 1; gbc.gridy = 6;
        txtTipo = new JTextField(20);
        fieldsPanel.add(txtTipo, gbc);

        // Linha 7: Status
        gbc.gridx = 0; gbc.gridy = 7;
        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblStatus, gbc);

        gbc.gridx = 1; gbc.gridy = 7;
        txtStatus = new JTextField(20);
        fieldsPanel.add(txtStatus, gbc);

        // Linha 8: Valor Diária
        gbc.gridx = 0; gbc.gridy = 8;
        JLabel lblValorDiaria = new JLabel("Valor Diária (ex.: 150.50):");
        lblValorDiaria.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblValorDiaria, gbc);

        gbc.gridx = 1; gbc.gridy = 8;
        txtValorDiaria = new JTextField(20);
        fieldsPanel.add(txtValorDiaria, gbc);

        // Linha 9: Data Check-in
        gbc.gridx = 0; gbc.gridy = 9;
        JLabel lblDataCheckin = new JLabel("Data Check-in (dd/mm/aaaa):");
        lblDataCheckin.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblDataCheckin, gbc);

        gbc.gridx = 1; gbc.gridy = 9;
        txtDataCheckin = new JTextField(20);
        fieldsPanel.add(txtDataCheckin, gbc);

        // Linha 10: Data Check-out
        gbc.gridx = 0; gbc.gridy = 10;
        JLabel lblDataCheckout = new JLabel("Data Check-out (dd/mm/aaaa):");
        lblDataCheckout.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblDataCheckout, gbc);

        gbc.gridx = 1; gbc.gridy = 10;
        txtDataCheckout = new JTextField(20);
        fieldsPanel.add(txtDataCheckout, gbc);

        // Linha 11: Data Pagamento
        gbc.gridx = 0; gbc.gridy = 11;
        JLabel lblDataPagamento = new JLabel("Data Pagamento (dd/mm/aaaa):");
        lblDataPagamento.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblDataPagamento, gbc);

        gbc.gridx = 1; gbc.gridy = 11;
        txtDataPagamento = new JTextField(20);
        fieldsPanel.add(txtDataPagamento, gbc);

        // Linha 12: Valor Total
        gbc.gridx = 0; gbc.gridy = 12;
        JLabel lblValorTotal = new JLabel("Valor Total (ex.: 752.50):");
        lblValorTotal.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblValorTotal, gbc);

        gbc.gridx = 1; gbc.gridy = 12;
        txtValorTotal = new JTextField(20);
        fieldsPanel.add(txtValorTotal, gbc);

        // Linha 13: Método Pagamento
        gbc.gridx = 0; gbc.gridy = 13;
        JLabel lblMetodoPagamento = new JLabel("Método Pagamento:");
        lblMetodoPagamento.setFont(new Font("Arial", Font.BOLD, 12));
        fieldsPanel.add(lblMetodoPagamento, gbc);

        gbc.gridx = 1; gbc.gridy = 13;
        txtMetodoPagamento = new JTextField(20);
        fieldsPanel.add(txtMetodoPagamento, gbc);

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
        btnCadastrar.addActionListener(e -> cadastrarCliente());
        btnBuscar.addActionListener(e -> buscarCliente());
        btnAlterar.addActionListener(e -> alterarCliente());
        btnExcluir.addActionListener(e -> excluirCliente());
        btnSalvarAlteracoes.addActionListener(e -> salvarAlteracoes());
        btnCancelar.addActionListener(e -> {
            limparCampos();
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnSalvarAlteracoes.setVisible(false);
            clienteSelecionado = null;
            
        });

        add(mainPanel);
        setVisible(true);
    }

    private void cadastrarCliente() {
        if (!validarCamposObrigatorios()) return;

        try {
            String nome = txtNome.getText().trim();
            String cpf = txtCpf.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String email = txtEmail.getText().trim();
            String numero = txtNumero.getText().trim();
            String tipo = txtTipo.getText().trim();
            String status = txtStatus.getText().trim();
            String valorDiaria = txtValorDiaria.getText().trim().replace(",", ".");
            String dataCheckin = txtDataCheckin.getText().trim();
            String dataCheckout = txtDataCheckout.getText().trim();
            String dataPagamento = txtDataPagamento.getText().trim();
            String valorTotal = txtValorTotal.getText().trim().replace(",", ".");
            String metodoPagamento = txtMetodoPagamento.getText().trim();

            double valorDiariaDouble = parseDoubleOrZero(valorDiaria);
            double valorTotalDouble = parseDoubleOrZero(valorTotal);

            SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
            sdfInput.setLenient(false);
            String dataCheckinConverted = dataCheckin.isEmpty() ? "" : sdfOutput.format(sdfInput.parse(dataCheckin));
            String dataCheckoutConverted = dataCheckout.isEmpty() ? "" : sdfOutput.format(sdfInput.parse(dataCheckout));
            String dataPagamentoConverted = dataPagamento.isEmpty() ? "" : sdfOutput.format(sdfInput.parse(dataPagamento));

            TelaCadastroCliente cliente = new TelaCadastroCliente(0, nome, cpf, telefone, email, numero, tipo, status,
                    String.valueOf(valorDiariaDouble), dataCheckinConverted, dataCheckoutConverted,
                    dataPagamentoConverted, String.valueOf(valorTotalDouble), metodoPagamento);
            TelaCadastroClienteDAO dao = new TelaCadastroClienteDAO();
            dao.adicionar(cliente);

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            limparCampos();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro nas datas! Use o formato dd/mm/aaaa.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void buscarCliente() {
        String nomeBusca = txtBuscarNome.getText().trim();
        if (nomeBusca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um nome para buscar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TelaCadastroClienteDAO dao = new TelaCadastroClienteDAO();
        List<TelaCadastroCliente> clientes = dao.listar();
        clienteSelecionado = null;

        for (TelaCadastroCliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeBusca)) {
                clienteSelecionado = cliente;
                break;
            }
        }

        if (clienteSelecionado != null) {
            txtNome.setText(clienteSelecionado.getNome());
            txtCpf.setText(clienteSelecionado.getCpf());
            txtTelefone.setText(clienteSelecionado.getTelefone());
            txtEmail.setText(clienteSelecionado.getEmail());
            txtNumero.setText(clienteSelecionado.getNumero());
            txtTipo.setText(clienteSelecionado.getTipo());
            txtStatus.setText(clienteSelecionado.getStatus());
            txtValorDiaria.setText(clienteSelecionado.getValor_Diaria());
            txtDataCheckin.setText(formatarData(clienteSelecionado.getData_Checkin()));
            txtDataCheckout.setText(formatarData(clienteSelecionado.getData_Checkout()));
            txtDataPagamento.setText(formatarData(clienteSelecionado.getData_Pagamento()));
            txtValorTotal.setText(clienteSelecionado.getValor_Total());
            txtMetodoPagamento.setText(clienteSelecionado.getMetodo_Pagamento());
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            limparCampos();
        }
    }

    private void alterarCliente() {
        if (clienteSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Busque um cliente antes de alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        btnCadastrar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnSalvarAlteracoes.setVisible(true);
    }

    private void salvarAlteracoes() {
        if (!validarCamposObrigatorios()) return;

        if (clienteSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado para alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String nome = txtNome.getText().trim();
            String cpf = txtCpf.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String email = txtEmail.getText().trim();
            String numero = txtNumero.getText().trim();
            String tipo = txtTipo.getText().trim();
            String status = txtStatus.getText().trim();
            String valorDiaria = txtValorDiaria.getText().trim().replace(",", ".");
            String dataCheckin = txtDataCheckin.getText().trim();
            String dataCheckout = txtDataCheckout.getText().trim();
            String dataPagamento = txtDataPagamento.getText().trim();
            String valorTotal = txtValorTotal.getText().trim().replace(",", ".");
            String metodoPagamento = txtMetodoPagamento.getText().trim();

            double valorDiariaDouble = parseDoubleOrZero(valorDiaria);
            double valorTotalDouble = parseDoubleOrZero(valorTotal);

            SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
            sdfInput.setLenient(false);
            String dataCheckinConverted = dataCheckin.isEmpty() ? "" : sdfOutput.format(sdfInput.parse(dataCheckin));
            String dataCheckoutConverted = dataCheckout.isEmpty() ? "" : sdfOutput.format(sdfInput.parse(dataCheckout));
            String dataPagamentoConverted = dataPagamento.isEmpty() ? "" : sdfOutput.format(sdfInput.parse(dataPagamento));

            clienteSelecionado.setNome(nome);
            clienteSelecionado.setCpf(cpf);
            clienteSelecionado.setTelefone(telefone);
            clienteSelecionado.setEmail(email);
            clienteSelecionado.setNumero(numero);
            clienteSelecionado.setTipo(tipo);
            clienteSelecionado.setStatus(status);
            clienteSelecionado.setValor_Diaria(String.valueOf(valorDiariaDouble));
            clienteSelecionado.setData_Checkin(dataCheckinConverted);
            clienteSelecionado.setData_Checkout(dataCheckoutConverted);
            clienteSelecionado.setData_Pagamento(dataPagamentoConverted);
            clienteSelecionado.setValor_Total(String.valueOf(valorTotalDouble));
            clienteSelecionado.setMetodo_Pagamento(metodoPagamento);

            TelaCadastroClienteDAO dao = new TelaCadastroClienteDAO();
            dao.atualizar(clienteSelecionado);
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
            limparCampos();
            btnSalvarAlteracoes.setVisible(false);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            clienteSelecionado = null;
            btnCadastrar.setEnabled(true);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro nas datas! Use o formato dd/mm/aaaa.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void excluirCliente() {
        if (clienteSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Busque um cliente antes de excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cliente " + clienteSelecionado.getNome() + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                TelaCadastroClienteDAO dao = new TelaCadastroClienteDAO();
                dao.excluir(clienteSelecionado.getId());
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
                limparCampos();
                btnAlterar.setEnabled(false);
                btnExcluir.setEnabled(false);
                clienteSelecionado = null;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtNumero.setText("");
        txtTipo.setText("");
        txtStatus.setText("");
        txtValorDiaria.setText("");
        txtDataCheckin.setText("");
        txtDataCheckout.setText("");
        txtDataPagamento.setText("");
        txtValorTotal.setText("");
        txtMetodoPagamento.setText("");
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
            txtNome.setBackground(new Color(255, 182, 193)); // Rosa claro para campos obrigatórios vazios
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
        if (txtNumero.getText().trim().isEmpty()) {
            txtNumero.setBackground(new Color(255, 182, 193));
            isValid = false;
        } else {
            txtNumero.setBackground(Color.WHITE);
        }
        if (!isValid) {
            JOptionPane.showMessageDialog(null, "Os campos com * são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }

    private void resetCampoObrigatorio() {
        txtNome.setBackground(Color.WHITE);
        txtCpf.setBackground(Color.WHITE);
        txtNumero.setBackground(Color.WHITE);
    }
    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastrarCliente());
    }
    */
}