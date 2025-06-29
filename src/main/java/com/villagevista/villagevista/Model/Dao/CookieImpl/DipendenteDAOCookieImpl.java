package com.villagevista.villagevista.Model.Dao.CookieImpl;

import com.villagevista.villagevista.Model.Dao.DipendenteDAO;
import com.villagevista.villagevista.Model.Mo.Admin;
import com.villagevista.villagevista.Model.Mo.Cliente;
import com.villagevista.villagevista.Model.Mo.Dipendente;
import com.villagevista.villagevista.Model.Mo.Turno_lavoro;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Date;
import java.util.List;

public class DipendenteDAOCookieImpl implements DipendenteDAO {
    HttpServletRequest request;
    HttpServletResponse response;
    public DipendenteDAOCookieImpl(HttpServletRequest request, HttpServletResponse response){
        this.request=request;
        this.response=response;
    }
    @Override
    public Dipendente create(
            String cf_dip,
            String nome_dip,
            String cognome_dip,
            String user_dip,
            String pass_dip,
            Date data_n,
            Float salario
            ){
        System.out.println("Creating Dipendente with nome: " + nome_dip + ", cognome: " + cognome_dip + ", username: " + user_dip);
        Dipendente loggedDipendente = new Dipendente();
        loggedDipendente.setNome_dip(nome_dip);
        loggedDipendente.setCognome_dip(cognome_dip);
        loggedDipendente.setUser_dip(user_dip);

        String encodedValue = encode(loggedDipendente);
        System.out.println("Encoded value: " + encodedValue); // Aggiungi questo per debug


        Cookie cookie;
        cookie = new Cookie("loggedDipendente", encode(loggedDipendente));
        cookie.setPath("/");
        response.addCookie(cookie);

        return loggedDipendente;
    }

    @Override
    public void update (Dipendente loggedDipendente){
        Cookie cookie;
        cookie = new Cookie("loggedDipendente",encode(loggedDipendente));
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    @Override
    public void delete(Long dipId){
        Cookie cookie;
        cookie=new Cookie("loggedDipendente","");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    @Override
    public Dipendente findLoggedDipendente(){

        Cookie[] cookies=request.getCookies();
        Dipendente loggedDipendente=null;

        if (cookies !=null){
            for (int i=0; i < cookies.length && loggedDipendente == null; i++){
                if (cookies[i].getName().equals("loggedDipendente")){
                    System.out.println("Found cookie: " + cookies[i].getValue());
                    loggedDipendente = decode(cookies[i].getValue());
                }
            }
        }
        return loggedDipendente;
    }
    @Override
    public Dipendente findByCf_dip(String Cf_dip){throw new UnsupportedOperationException("Not supported.");}
@Override
public List<Dipendente> findAllDipendenti(){throw new UnsupportedOperationException("non supported");}
    @Override
    public Dipendente findByDipId(Long dipId){throw new UnsupportedOperationException("Not Supported");}
    private String encode(Dipendente loggedDipendente){
        String encodedLoggedDipendente;

        encodedLoggedDipendente = loggedDipendente.getUser_dip() + "#" + loggedDipendente.getNome_dip() + "#" + loggedDipendente.getCognome_dip();
        return encodedLoggedDipendente;
    }
    @Override
    public Dipendente findByUser_dip(String user_dip) {
        throw new UnsupportedOperationException("Not supported.");
    }
    private Dipendente decode(String encodedLoggedDipendente){

        Dipendente loggedDipendente = new Dipendente();

        String[] values = encodedLoggedDipendente.split("#");

        loggedDipendente.setUser_dip(values[0]);
        loggedDipendente.setNome_dip(values[1]);
        loggedDipendente.setCognome_dip(values[2]);

        return loggedDipendente;
    }

}
