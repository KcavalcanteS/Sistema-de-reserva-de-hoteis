package Models;

public class Reservas {
    public String id_reserva;
    public String data_checkin;
    public String data_checkout;
    
    public Reservas(String id_reserva, String data_checkin, String data_checkout){
        this.id_reserva = id_reserva;
        this.data_checkin = data_checkin;
        this.data_checkout = data_checkout;
    }
    
    public String getId_reserva(){
        return id_reserva;
    }
   public String getdata_checkin(){
        return data_checkin;
    }
   public String getdata_checkout(){
        return data_checkout;
    }
   
   public String setId_reserva(){
        return id_reserva;
    }
    
   public String setdata_checkin(){
        return data_checkin;
    }
   public String setdata_checkout(){
        return data_checkout;
    }
    
}