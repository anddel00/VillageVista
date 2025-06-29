package com.villagevista.villagevista.Model.Dao;

import com.villagevista.villagevista.Model.Mo.Prenotazione;
import com.villagevista.villagevista.Model.Mo.Cliente;

import java.util.List;

public interface ClienteDAO {

    public Cliente create(
            String nome_cliente,
            String cognome_cliente,
            String telefono,
            String email,
            String user_cliente,
            String pass_cliente
            );
    public void update (Cliente cliente);
    public void delete (Long num_p);
    public  Cliente findByCognome_cliente(String cognome_cliente);
    public Cliente findByNum_P(Long num_P);
    public Cliente findLoggedCliente();
    public Cliente findByUser_cliente(String user_cliente);
    public List<Cliente> findAllClienti();

}

