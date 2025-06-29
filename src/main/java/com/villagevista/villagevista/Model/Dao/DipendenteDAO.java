package com.villagevista.villagevista.Model.Dao;

import com.villagevista.villagevista.Model.Mo.Admin;
import com.villagevista.villagevista.Model.Mo.Dipendente;
import com.villagevista.villagevista.Model.Mo.Turno_lavoro;

import java.sql.Date;
import java.util.List;

public interface DipendenteDAO {

    public Dipendente create(
            String cf_dip,
            String nome_dip,
            String cognome_dip,
            String user_dip,
            String pass_dip,
            Date data_n,
            Float salario
            );

    public void update(Dipendente dipendente);
    public void delete(Long dipId);
    public Dipendente findLoggedDipendente();
    public List<Dipendente> findAllDipendenti();
    public Dipendente findByDipId(Long dipId);
    public Dipendente findByCf_dip(String cf_dip);
    public Dipendente findByUser_dip(String user_dip);

}



