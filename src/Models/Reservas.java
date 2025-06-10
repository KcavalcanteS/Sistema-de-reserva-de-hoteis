package Models;

public class Reservas {
    int id_reserva;
    String data_checkin;
    String data_checkout;

    //getters
    public int getId_reserva(){
        return id_reserva;
    }
   public String getdata_checkin(){
        return data_checkin;
    }
   public String getdata_checkout(){
        return data_checkout;
    }
   
   //setters
   public void setId_reserva(int id_reserva){
        this.id_reserva = id_reserva;
    }
    
   public void setdata_checkin(String data_checkin){
        this.data_checkin = data_checkin;
    }
   public void setdata_checkout(String data_checkout){
        this.data_checkout = data_checkout;
    }
    
}