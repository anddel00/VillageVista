package com.villagevista.villagevista.Model.Mo;

public class Admin {

        private Long adminId;
        private String username;
        private String password;
        private String nome;
        private String cognome;
        private String cf_admin;

    public Long getAdminId(){return adminId;}
    public void setAdminId(Long adminId){this.adminId = adminId;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}

    public String getCognome(){return cognome;}
    public void setCognome(String cognome){this.cognome = cognome;}

    public String getCf_admin(){return cf_admin;}
    public void setCf_admin(String cf_admin){this.cf_admin = cf_admin;}

}
