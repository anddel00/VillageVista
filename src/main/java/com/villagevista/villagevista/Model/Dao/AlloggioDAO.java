package com.villagevista.villagevista.Model.Dao;

import com.villagevista.villagevista.Model.Mo.Alloggio;

import java.util.Date;
import java.util.List;

public interface AlloggioDAO {
    public Alloggio create(
            Long num_alloggio,
            String tipo,
            String capienza,
            String occupato,
            Date data_inizio,
            Date data_fine,
            Long prezzonotte
    );

    public void update (Alloggio alloggio);

    public void delete (Alloggio alloggio);

    public void booked (Alloggio alloggio);
    public Alloggio findByNum_alloggio(Long num_alloggio);
    public Alloggio findByCapienza(String capienza);
    public void bookedDate(Long num_alloggio, Date data_inizio, Date data_fine);
    public List<Alloggio> findAll();
    public void free (Alloggio alloggio);
    public List<Alloggio> findDisponibili(String tipo, String capienza, Date data_inizio, Date data_fine);
    public List<Alloggio> findDisponibilita(String tipo, String capienza, Date data_inizio, Date data_fine);
}
