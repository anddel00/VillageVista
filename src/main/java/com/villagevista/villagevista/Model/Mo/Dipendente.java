package com.villagevista.villagevista.Model.Mo;

import java.util.Date;

public class Dipendente {

    private Long dipId;
    private String user_dip;
    private String pass_dip;
    private String cf_dip;
    private String nome_dip;
    private String cognome_dip;
    private java.sql.Date data_n;
    private String ruolo;
    private Float salario;

    public Long getDipId() {
        return dipId;
    }

    public void setDipId(Long dipId) {
        this.dipId = dipId;
    }

    public String getPass_dip() {
        return pass_dip;
    }

    public void setPass_dip(String pass_dip) {
        this.pass_dip = pass_dip;
    }

    public String getUser_dip() {
        return user_dip;
    }

    public void setUser_dip(String user_dip) {
        this.user_dip = user_dip;
    }

    public String getCf_dip() {
        return cf_dip;
    }

    public void setCf_dip(String cf_dip) {
        this.cf_dip = cf_dip;
    }

    public String getNome_dip() {
        return nome_dip;
    }

    public void setNome_dip(String nome_dip) {
        this.nome_dip = nome_dip;
    }

    public String getCognome_dip() {
        return cognome_dip;
    }

    public void setCognome_dip(String cognome_dip) {
        this.cognome_dip = cognome_dip;
    }

    public java.sql.Date getData_n() {
        return data_n;
    }

    public void setData_n(Date data_n) {
        this.data_n = (java.sql.Date) data_n;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }
}