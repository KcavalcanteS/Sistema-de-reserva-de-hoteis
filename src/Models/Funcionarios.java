package Models;

public class Funcionarios extends Pessoas{
    int id_funcionario;
    String cargo;
    String login;
    String senha;
    
    //getters
    public int getId_funcionario(){
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
    
    //setters
    public void setId_funcionario(int id_funcionario){
        this.id_funcionario = id_funcionario;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
}