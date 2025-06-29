package com.villagevista.villagevista.Model.Dao.CookieImpl;

import com.villagevista.villagevista.Model.Dao.ClienteDAO;
import com.villagevista.villagevista.Model.Mo.Cliente;
import com.villagevista.villagevista.Model.Mo.Prenotazione;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class ClienteDAOCookieImpl implements ClienteDAO {
    HttpServletRequest request;
    HttpServletResponse response;

    public ClienteDAOCookieImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public Cliente create(
            String nome_cliente,
            String cognome_cliente ,
            String telefono,
            String email,
            String user_cliente,
            String pass_cliente
    ) {
        Cliente loggedCliente = new Cliente();

        loggedCliente.setUser_cliente(user_cliente);
        loggedCliente.setNome_cliente(nome_cliente);
        loggedCliente.setCognome_cliente(cognome_cliente);

        Cookie cookie;
        cookie = new Cookie ("loggedCliente",encode(loggedCliente));
        cookie.setPath("/");
        response.addCookie(cookie);
        return loggedCliente;

    }
    @Override
    public void update (Cliente loggedCliente){
        Cookie cookie;
        cookie = new Cookie("loggedCliente",encode (loggedCliente));
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    @Override
    public void delete(Long num_p){
        Cookie cookie;
        cookie = new Cookie("loggedCliente","");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public Cliente findLoggedCliente() {
        Cookie[] cookies = request.getCookies();
        Cliente loggedCliente = null;

        if (cookies != null) {
            for (int i = 0; i < cookies.length && loggedCliente== null; i++) {
                if (cookies[i].getName().equals("loggedCliente")) {
                    loggedCliente = decode(cookies[i].getValue());
                }
            }
        }

        return loggedCliente;
    }
    @Override
    public Cliente findByNum_P(Long num_p){throw new UnsupportedOperationException("Not supported");}
@Override
public Cliente findByCognome_cliente(String cognome_cliente){throw new UnsupportedOperationException("not supported");}
    @Override
    public Cliente findByUser_cliente(String user_cliente){throw new UnsupportedOperationException("not supported yet");}

    @Override
    public List<Cliente> findAllClienti() {throw new UnsupportedOperationException("not supported yet");}

    public String encode(Cliente loggedCliente){

        String encodedLoggedCliente;
        encodedLoggedCliente = loggedCliente.getUser_cliente() + "#" + loggedCliente.getNome_cliente() + "#" + loggedCliente.getCognome_cliente();
        return encodedLoggedCliente;
    }
    private Cliente decode(String encodedLoggedCliente){

        Cliente loggedCliente=new Cliente();

        String[] values = encodedLoggedCliente.split("#");

        loggedCliente.setUser_cliente(values[0]);
        loggedCliente.setNome_cliente(values[1]);
        loggedCliente.setCognome_cliente(values[2]);

        return loggedCliente;
    }


}
