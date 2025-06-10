package Models;

public class Quartos {
    public String id_quarto;
    public int numero;
    public String tipo;
    public String status;
    public float valor_diaria;
    
    public Quartos(String id_quarto, int numero, String tipo, String status, float valor_diaria){
        this.id_quarto = id_quarto;
        this.numero = numero;
        this.tipo = tipo;
        this.status = status;
        this.valor_diaria = valor_diaria;
    }
    
    public String getId_quarto(){
        return id_quarto;
    }
    public Integer getNumero(){
        return numero;
    }
    public String getTipo(){
        return tipo;
    }
    public String getStatus(){
        return status;
    }
    public float getvalor_diaria(){
        return valor_diaria;
    }
    
    public String setId_quarto(){
        return id_quarto;
    }
    public Integer setNumero(){
        return numero;
    }
    public String setTipo(){
        return tipo;
    }
    public String setStatus(){
        return status;
    }
    public float setvalor_diaria(){
        return valor_diaria;
    }
    
}