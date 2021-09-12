package sample.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Evidencijarada {

  private long evidencijaId;
  private java.sql.Time vrijemePocetka;
  private java.sql.Time vrijemeKraja;
  private java.sql.Date datum;
  private double ukupnoVrijemeRada;
  private double prekovremeni;
  private long korisnikId;
  private long statusId;
  private String inOut;
  private String ime;
  private String prezime;
  private String radnoMjesto;

  public String getIme() {
    return ime;
  }

  public void setIme(String ime) {
    this.ime = ime;
  }

  public String getPrezime() {
    return prezime;
  }

  public void setPrezime(String prezime) {
    this.prezime = prezime;
  }

  public String getRadnoMjesto() {
    return radnoMjesto;
  }

  public void setRadnoMjesto(String radnoMjesto) {
    this.radnoMjesto = radnoMjesto;
  }

  public Evidencijarada(Time vrijemePocetka, Time vrijemeKraja, Date datum, String inOut, String ime, String prezime, String radnoMjesto) {
    this.vrijemePocetka = vrijemePocetka;
    this.vrijemeKraja = vrijemeKraja;
    this.datum = datum;
    this.inOut = inOut;
    this.ime = ime;
    this.prezime = prezime;
    this.radnoMjesto = radnoMjesto;
  }


  public long getEvidencijaId() {
    return evidencijaId;
  }

  public void setEvidencijaId(long evidencijaId) {
    this.evidencijaId = evidencijaId;
  }


  public java.sql.Time getVrijemePocetka() {
    return vrijemePocetka;
  }

  public void setVrijemePocetka(java.sql.Time vrijemePocetka) {
    this.vrijemePocetka = vrijemePocetka;
  }


  public java.sql.Time getVrijemeKraja() {
    return vrijemeKraja;
  }

  public void setVrijemeKraja(java.sql.Time vrijemeKraja) {
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


  public String getInOut() {
    return inOut;
  }

  public void setInOut(String inOut) {
    this.inOut = inOut;
  }

  // get all records

  public static ObservableList<Evidencijarada> getAllAttendanceRecords(){
    ObservableList<Evidencijarada> recordsList = FXCollections.observableArrayList();
    Baza db = new Baza();
    PreparedStatement ps = db.exec("SELECT k.Ime, k.Prezime, r.ImeRadnogMjesta, ev.VrijemePocetka, ev.VrijemeKraja, ev.Datum, ev.`InOut`\n" +
            "FROM evidencijarada as ev \n" +
            "INNER JOIN korisnici as k on ev.KorisnikID = k.KorisnikID \n" +
            "INNER JOIN radnomjesto r on k.RadnoMjestoID = r.RadnoMjestoID");
    try{
      ResultSet rs= ps.executeQuery();
      while(rs.next()){
        recordsList.add(new Evidencijarada(
                rs.getTime("VrijemePocetka"),
                rs.getTime("VrijemeKraja"),
                rs.getDate("Datum"),
                rs.getLong("InOut") == 1 ? "In" : "Out",
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("ImeRadnogMjesta")));
      }
    } catch (SQLException ex) {
      System.out.println("SQL greška: "+ ex);

    }
    return recordsList;
  }

  public static ObservableList<Evidencijarada> getAllAttendanceRecords(Date pickedDate) throws SQLException {
    ObservableList<Evidencijarada> recordsList = FXCollections.observableArrayList();
    Baza db = new Baza();
    PreparedStatement ps = db.exec("SELECT k.Ime, k.Prezime, r.ImeRadnogMjesta, ev.VrijemePocetka, ev.VrijemeKraja, ev.Datum, ev.`InOut`\n" +
            "FROM evidencijarada as ev \n" +
            "INNER JOIN korisnici as k on ev.KorisnikID = k.KorisnikID \n" +
            "INNER JOIN radnomjesto r on k.RadnoMjestoID = r.RadnoMjestoID \n" +
            "WHERE ev.Datum = ?");
    ps.setDate(1, pickedDate);
    try{
      ResultSet rs= ps.executeQuery();
      while(rs.next()){
        recordsList.add(new Evidencijarada(
                rs.getTime("VrijemePocetka"),
                rs.getTime("VrijemeKraja"),
                rs.getDate("Datum"),
                rs.getLong("InOut") == 1 ? "In" : "Out",
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("ImeRadnogMjesta")));
      }
    } catch (SQLException ex) {
      System.out.println("SQL greška: "+ ex);

    }
    return recordsList;
  }

  public static ObservableList<Evidencijarada> getAllAttendanceRecords(int id){
    ObservableList<Evidencijarada> recordsList = FXCollections.observableArrayList();
    Baza db = new Baza();
    PreparedStatement ps = db.exec("SELECT k.Ime, k.Prezime, r.ImeRadnogMjesta, ev.VrijemePocetka, ev.VrijemeKraja, ev.Datum, ev.`InOut`\n" +
            "            FROM evidencijarada as ev \n" +
            "            INNER JOIN korisnici as k on ev.KorisnikID = k.KorisnikID \n" +
            "            INNER JOIN radnomjesto r on k.RadnoMjestoID = r.RadnoMjestoID\n" +
            "            WHERE ev.KorisnikID =?");
    try{
      ps.setInt(1, id);
      ResultSet rs= ps.executeQuery();
      while(rs.next()){
        recordsList.add(new Evidencijarada(
                rs.getTime("VrijemePocetka"),
                rs.getTime("VrijemeKraja"),
                rs.getDate("Datum"),
                rs.getLong("InOut") == 1 ? "In" : "Out",
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("ImeRadnogMjesta")));
      }
    } catch (SQLException ex) {
      System.out.println("SQL greška: "+ ex);

    }
    return recordsList;
  }
  public static ObservableList<Evidencijarada> getAllAttendanceRecords(Date pickedDate, int id) throws SQLException {
    ObservableList<Evidencijarada> recordsList = FXCollections.observableArrayList();
    Baza db = new Baza();
    PreparedStatement ps = db.exec("SELECT k.Ime, k.Prezime, r.ImeRadnogMjesta, ev.VrijemePocetka, ev.VrijemeKraja, ev.Datum, ev.`InOut`\n" +
            "FROM evidencijarada as ev \n" +
            "INNER JOIN korisnici as k on ev.KorisnikID = k.KorisnikID \n" +
            "INNER JOIN radnomjesto r on k.RadnoMjestoID = r.RadnoMjestoID \n" +
            "WHERE ev.Datum = ? and ev.KorisnikID = ?");
    ps.setDate(1, pickedDate);
    ps.setInt(2, id);
    try{
      ResultSet rs= ps.executeQuery();
      while(rs.next()){
        recordsList.add(new Evidencijarada(
                rs.getTime("VrijemePocetka"),
                rs.getTime("VrijemeKraja"),
                rs.getDate("Datum"),
                rs.getLong("InOut") == 1 ? "In" : "Out",
                rs.getString("Ime"),
                rs.getString("Prezime"),
                rs.getString("ImeRadnogMjesta")));
      }
    } catch (SQLException ex) {
      System.out.println("SQL greška: "+ ex);

    }
    return recordsList;
  }

}
