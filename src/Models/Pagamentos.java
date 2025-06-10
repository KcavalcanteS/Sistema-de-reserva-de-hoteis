package Models;

public class Pagamentos {
    int id_pagamento;
    float valor;
    String data_pagamento;
    String metodo;
   
    //getters
    public int getId_pagamento(){
        return id_pagamento;
    }
    public float getValor(){
        return valor;
    }
    public String getData_pagamento(){
        return data_pagamento;
    }
    public String getMetodo(){
        return metodo;
    }
    
    //setters
    public void setId_pagamento(int id_pagamento){
        this.id_pagamento = id_pagamento;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
    public void setData_pagamento(String data_pagamento){
        this.data_pagamento = data_pagamento;
    }
    public void setMetodo(String metodo){
        this.metodo = metodo;
    }
}