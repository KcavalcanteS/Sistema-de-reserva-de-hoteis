/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HP
 */
public class TelaCadastroCliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String numero;
    private String tipo;
    private String status;
    private String valor_Diaria;
    private String data_Checkin;
    private String data_Checkout;
    private String data_Pagamento;
    private String valor_Total;
    private String metodo_Pagamento;

    public TelaCadastroCliente(int id, String nome, String cpf, String telefone, String email, String numero,
                               String tipo, String status, String valor_Diaria, String data_Checkin,
                               String data_Checkout, String data_Pagamento, String valor_Total, String metodo_Pagamento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.numero = numero;
        this.tipo = tipo;
        this.status = status;
        this.valor_Diaria = valor_Diaria;
        this.data_Checkin = data_Checkin;
        this.data_Checkout = data_Checkout;
        this.data_Pagamento = data_Pagamento;
        this.valor_Total = valor_Total;
        this.metodo_Pagamento = metodo_Pagamento;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getValor_Diaria() { return valor_Diaria; }
    public void setValor_Diaria(String valor_Diaria) { this.valor_Diaria = valor_Diaria; }
    public String getData_Checkin() { return data_Checkin; }
    public void setData_Checkin(String data_Checkin) { this.data_Checkin = data_Checkin; }
    public String getData_Checkout() { return data_Checkout; }
    public void setData_Checkout(String data_Checkout) { this.data_Checkout = data_Checkout; }
    public String getData_Pagamento() { return data_Pagamento; }
    public void setData_Pagamento(String data_Pagamento) { this.data_Pagamento = data_Pagamento; }
    public String getValor_Total() { return valor_Total; }
    public void setValor_Total(String valor_Total) { this.valor_Total = valor_Total; }
    public String getMetodo_Pagamento() { return metodo_Pagamento; }
    public void setMetodo_Pagamento(String metodo_Pagamento) { this.metodo_Pagamento = metodo_Pagamento; }
}