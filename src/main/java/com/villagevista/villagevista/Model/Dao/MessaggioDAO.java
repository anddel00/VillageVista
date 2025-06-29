package com.villagevista.villagevista.Model.Dao;

import com.villagevista.villagevista.Model.Mo.Messaggio;

import java.util.List;

public interface MessaggioDAO {

    public Messaggio create(
            Long id_messaggio_cliente,
            Long id_messaggio,
            String testo,
            String letto
    );


    public void delete (Long id_messaggio);
}
