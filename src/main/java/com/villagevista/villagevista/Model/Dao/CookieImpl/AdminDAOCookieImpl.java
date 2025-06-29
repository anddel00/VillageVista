package com.villagevista.villagevista.Model.Dao.CookieImpl;

import com.villagevista.villagevista.Model.Dao.AdminDAO;
import com.villagevista.villagevista.Model.Mo.Admin;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class AdminDAOCookieImpl  implements AdminDAO {
    HttpServletRequest request;
    HttpServletResponse response;
    public AdminDAOCookieImpl(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response=response;
    }
    @Override
    public Admin create(
            Long adminId,
            String username,
            String password,
            String nome,
            String cf_admin,
            String cognome){
        Admin loggedAdmin = new Admin();
        loggedAdmin.setAdminId(adminId);
        loggedAdmin.setNome(nome);
        loggedAdmin.setCognome(cognome);

        String encodedValue = encode(loggedAdmin);
        System.out.println("Encoded value: " + encodedValue); // Aggiungi questo per debug


        Cookie cookie;
        cookie = new Cookie ("loggedAdmin", encode(loggedAdmin));
        cookie.setPath("/");
        response.addCookie(cookie);

        return loggedAdmin;
    }
    @Override
    public void update(Admin loggedAdmin){
        Cookie cookie;
        cookie = new Cookie ("loggedAdmin", encode(loggedAdmin));
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    @Override
    public void delete(Admin loggedAdmin) {

        Cookie cookie;
        cookie = new Cookie("loggedAdmin", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

    }
    @Override
    public Admin findLoggedAdmin() {

        Cookie[] cookies = request.getCookies();
        Admin loggedAdmin = null;

        if (cookies != null) {
            for (int i = 0; i < cookies.length && loggedAdmin == null; i++) {
                if (cookies[i].getName().equals("loggedAdmin")) {
                    loggedAdmin = decode(cookies[i].getValue());
                }
            }
        }

        return loggedAdmin;

    }
    @Override
    public Admin findByAdminId(Long adminId) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public Admin findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported.");
    }
    @Override
    public Admin validate (String username, String password){throw new UnsupportedOperationException("not supported yet");}
    private String encode(Admin loggedAdmin) {

        String encodedLoggedAdmin;
        encodedLoggedAdmin = loggedAdmin.getAdminId()+"#"+loggedAdmin.getNome()+"#"+loggedAdmin.getCognome();
        return encodedLoggedAdmin;

    }
    @Override
    public List<Admin> findAllAdmins(){throw new UnsupportedOperationException("Not supported");}

    private Admin decode(String encodedLoggedAdmin) {

        Admin loggedAdmin = new Admin();

        String[] values = encodedLoggedAdmin.split("#");

        loggedAdmin.setAdminId(Long.parseLong(values[0]));
        loggedAdmin.setNome(values[1]);
        loggedAdmin.setCognome(values[2]);

        return loggedAdmin;

    }



}
