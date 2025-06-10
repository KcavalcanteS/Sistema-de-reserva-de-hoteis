package Models;

public class Funcionarios extends Pessoas{
    public String id_funcionario;
    public String cargo;
    public String login;
    public String senha;
    
    public Funcionarios(String nome, String id_funcionario, String cargo, String login, String senha){
        this.nome = nome;
        this.id_funcionario = id_funcionario;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }
    
    public String getId_funcionario(){
        return id_funcionario;
    }
    public String getCargo(){
        return cargo;
    }
    public String getLogin(){
        return login;
    }
    public String getSenha(){
        return senha;
    }
    
    public String setId_funcionario(){
        return id_funcionario;
    }
    public String setCargo(){
        return cargo;
    }
    public String setLogin(){
        return login;
    }
    public String setSenha(){
        return senha;
    }
}