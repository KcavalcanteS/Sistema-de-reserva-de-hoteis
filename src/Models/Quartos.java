package Models;

public class Quartos {
    int id_quarto;
    int numero;
    String tipo;
    boolean status;
    float valor_diaria;
    
    public int getId_quarto(){
        return id_quarto;
    }
    public Integer getNumero(){
        return numero;
    }
    public String getTipo(){
        return tipo;
    }
    public boolean getStatus(){
        return status;
    }
    public float getvalor_diaria(){
        return valor_diaria;
    }
    
    public void setId_quarto(int id_quarto){
        this.id_quarto = id_quarto;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public float setvalor_diaria(){
        return valor_diaria;
    }
    
}