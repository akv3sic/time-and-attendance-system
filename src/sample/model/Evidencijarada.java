package sample.model;


public class Evidencijarada {

  private long evidencijaId;
  private java.sql.Timestamp vrijemePocetka;
  private java.sql.Timestamp vrijemeKraja;
  private java.sql.Date datum;
  private double ukupnoVrijemeRada;
  private double prekovremeni;
  private long korisnikId;
  private long statusId;


  public long getEvidencijaId() {
    return evidencijaId;
  }

  public void setEvidencijaId(long evidencijaId) {
    this.evidencijaId = evidencijaId;
  }


  public java.sql.Timestamp getVrijemePocetka() {
    return vrijemePocetka;
  }

  public void setVrijemePocetka(java.sql.Timestamp vrijemePocetka) {
    this.vrijemePocetka = vrijemePocetka;
  }


  public java.sql.Timestamp getVrijemeKraja() {
    return vrijemeKraja;
  }

  public void setVrijemeKraja(java.sql.Timestamp vrijemeKraja) {
    this.vrijemeKraja = vrijemeKraja;
  }


  public java.sql.Date getDatum() {
    return datum;
  }

  public void setDatum(java.sql.Date datum) {
    this.datum = datum;
  }


  public double getUkupnoVrijemeRada() {
    return ukupnoVrijemeRada;
  }

  public void setUkupnoVrijemeRada(double ukupnoVrijemeRada) {
    this.ukupnoVrijemeRada = ukupnoVrijemeRada;
  }


  public double getPrekovremeni() {
    return prekovremeni;
  }

  public void setPrekovremeni(double prekovremeni) {
    this.prekovremeni = prekovremeni;
  }


  public long getKorisnikId() {
    return korisnikId;
  }

  public void setKorisnikId(long korisnikId) {
    this.korisnikId = korisnikId;
  }


  public long getStatusId() {
    return statusId;
  }

  public void setStatusId(long statusId) {
    this.statusId = statusId;
  }

}
