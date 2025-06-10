package Models;

public class Clientes extends Pessoas{
    int id_cliente;
    String telefone;
    String email;
    
    //getters
    public int getId_cliente(){
        return id_cliente;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getEmail(){
        return email;
    }
    
    //setteres
    public void setId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setEmail (String email){
        this.email = email;
    }
}