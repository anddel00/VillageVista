package com.villagevista.villagevista.Model.Mo;

public class Messaggio {
    private Long id_messaggio_cliente;
    private Long id_messaggio;
    private String testo;
    private String letto;

    public Long getId_messaggio_cliente(){return id_messaggio_cliente;}
    public void setId_messaggio_cliente(Long id_messaggio_cliente){this.id_messaggio_cliente = id_messaggio_cliente;}
    public Long getId_messaggio(){return id_messaggio;}
    public void setId_messaggio(Long id_messaggio){this.id_messaggio=id_messaggio;}
    public String getTesto(){return testo;}
    public void setTesto(String testo){this.testo=testo;}
    public String getletto(){return letto;}
    public void setLetto(String letto){this.letto=letto;}

}
