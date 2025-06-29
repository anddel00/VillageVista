package com.villagevista.villagevista.Model.Mo;

import java.util.Date;

public class Alloggio {
    private Long num_alloggio;
    private String tipo;
    private String capienza;
    private String occupato;
     private Date data_inizio;
     private Date data_fine;
     private Long prezzonotte;

     public Long getNum_alloggio(){return  num_alloggio;}
    public void setNum_alloggio(Long num_alloggio){this.num_alloggio=num_alloggio;}
    public String getTipo(){return tipo;}
    public void setTipo(String tipo){this.tipo = tipo;}
    public String getCapienza(){return capienza;}
    public void setCapienza(String capienza){this.capienza = capienza;}
    public String getOccupato(){return occupato;}
    public void setOccupato(String occupato){this.occupato = occupato;}

    public java.sql.Date getData_inizio() {return (java.sql.Date) data_inizio;}

    public void setData_inizio(Date data_inizio) {this.data_inizio = data_inizio;}
    public java.sql.Date getData_fine() {return (java.sql.Date) data_fine;}
    public void setData_fine(Date data_fine) {this.data_fine = data_fine;}
    public Long getPrezzonotte(){return prezzonotte;}
    public void setPrezzonotte(Long prezzonotte){this.prezzonotte = prezzonotte;}

}
