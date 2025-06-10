package Models;

public class Pagamentos {
    public String id_pagamento;
    public float valor;
    public String data_pagamento;
    public String metodo;
    
    public Pagamentos(String id_pagamento, float valor, String data_pagamento, String metodo){
        this.id_pagamento = id_pagamento;
        this.valor = valor;
        this.data_pagamento = data_pagamento;
        this.metodo = metodo;
    }
    
    public String getId_pagamento(){
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
    
    public String setId_pagamento(){
        return id_pagamento;
    }
    public float setValor(){
        return valor;
    }
    public String setData_pagamento(){
        return data_pagamento;
    }
    public String setMetodo(){
        return metodo;
    }
}