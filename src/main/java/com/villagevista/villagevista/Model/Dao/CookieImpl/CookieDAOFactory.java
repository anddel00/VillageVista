package com.villagevista.villagevista.Model.Dao.CookieImpl;


import com.villagevista.villagevista.Model.Dao.*;
import com.villagevista.villagevista.Model.Dao.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

public class CookieDAOFactory extends DAOFactory {
    private Map factoryParameters;
    private HttpServletRequest request;
    private HttpServletResponse response;
    public CookieDAOFactory(Map factoryParameters) {this.factoryParameters=factoryParameters;}

    @Override
    public void beginTransaction() {
        // Implementazione del metodo beginTransaction()
        try {
            this.request=(HttpServletRequest) factoryParameters.get("request");
            this.response=(HttpServletResponse) factoryParameters.get("response");
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
@Override
    public void commitTransaction(){}
    @Override
    public void rollbackTransaction(){}
    @Override
    public void closeTransaction(){}

    @Override
    public AdminDAO getAdminDAO() {return new AdminDAOCookieImpl(request,response);}

    @Override
    public AlloggioDAO getAlloggioDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ClienteDAO getClienteDAO() {return new ClienteDAOCookieImpl(request,response);}

    @Override
    public DipendenteDAO getDipendenteDAO() {return new DipendenteDAOCookieImpl(request,response);}

    @Override
    public PrenotazioneDAO getPrenotazioneDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Turno_lavoroDAO getTurno_lavoroDAO(){throw new UnsupportedOperationException("not suported yet");}
    @Override
    public MessaggioDAO getMessaggioDAO(){throw new UnsupportedOperationException("not supported yet.");}




}
