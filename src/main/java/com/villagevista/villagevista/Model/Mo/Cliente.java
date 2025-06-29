package com.villagevista.villagevista.Model.Mo;

public class Cliente {
    private String nome_cliente;
    private String cognome_cliente;
    private String telefono;
    private String email;
    private Long num_p;
    private String user_cliente;
    private String pass_cliente;
    private Prenotazione prenotazione;


    public Long getNum_p(){return num_p;}
    public void setNum_p(Long num_p){this.num_p = num_p;}
    public String getNome_cliente(){return nome_cliente;}
    public void setNome_cliente(String nome_cliente){this.nome_cliente=nome_cliente;}
    public String getCognome_cliente(){return cognome_cliente;}
    public void setCognome_cliente(String cognome_cliente){this.cognome_cliente=cognome_cliente;}
    public String getTelefono(){return telefono;}
    public void  setTelefono(String telefono){this.telefono = telefono;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public String getUser_cliente(){return user_cliente;}
    public void setUser_cliente(String user_cliente){this.user_cliente=user_cliente;}
    public String getPass_cliente(){return pass_cliente;}
    public void setPass_cliente(String pass_cliente){this.pass_cliente=pass_cliente;}

    public Prenotazione getPrenotazione(){return prenotazione;}
    public void setPrenotazione(Prenotazione prenotazione){this.prenotazione = prenotazione;}

}
