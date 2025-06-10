package Models;

public class Clientes extends Pessoas{
    public String id_cliente;
    public String telefone;
    public String email;
    public String cpf;
    
    public Clientes(String nome, String id_cliente,String email, String cpf, String telefone){
        this.nome = nome;
        this.id_cliente = id_cliente;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public String getId_cliente(){
        return id_cliente;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getEmail(){
        return email;
    }
    public String getCpf(){
        return cpf;
    }
    
    public String setId_cliente(){
        return id_cliente;
    }
    public String setTelefone(){
        return telefone;
    }
    public String setEmail (){
        return email;
    }
    public String setCpf (){
        return cpf;
    }
}