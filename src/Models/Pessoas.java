package Models;

public class Pessoas {
    String nome;
    String cpf;
    
    //getters
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    
    //setters
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public void setCpf (String cpf){
        this.cpf = cpf;
    }
}

