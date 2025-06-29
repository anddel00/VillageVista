package com.villagevista.villagevista.Model.Mo;

import java.sql.Date;

public class Turno_lavoro {
  private Long id_dip_turno;
  private Long turno_id;
  private String ora_inizio;
  private String ora_fine;
  private Date data_turno;
  private String cognome_turno;
  private Dipendente dipendente;


  public Long getId_dip_turno(){return id_dip_turno;}
  public void setId_dip_turno(Long id_dip_turno){this.id_dip_turno = id_dip_turno;}

  public Long getTurno_id(){return turno_id;}
  public void setTurno_id(Long turno_id){this.turno_id = turno_id;}

  public String getOra_inizio(){return ora_inizio;}
  public void setOra_inizio (String ora_inizio){this.ora_inizio = ora_inizio;}

  public String getOra_fine(){return ora_fine;}
  public void setOra_fine (String ora_fine){this.ora_fine = ora_fine;}

  public Date getData_turno(){return data_turno;}
  public void setData_turno(Date data_turno){this.data_turno = data_turno;}

  public String getCognome_turno(){return cognome_turno;}
  public void setCognome_turno (String cognome_turno){this.cognome_turno = cognome_turno;}

  public Dipendente getDipendente(){return  dipendente;}
  public void setDipendente (Dipendente dipendente){this.dipendente = dipendente;}





}
