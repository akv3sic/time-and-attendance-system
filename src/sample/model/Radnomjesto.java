package sample.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Radnomjesto {

  private long radnoMjestoId;
  private String imeRadnogMjesta;
  private double satnica;
  private String isDeleted;

  public Radnomjesto(long radnoMjestoId, String imeRadnogMjesta, double satnica, String isDeleted) {
    this.radnoMjestoId = radnoMjestoId;
    this.imeRadnogMjesta = imeRadnogMjesta;
    this.satnica = satnica;
    this.isDeleted = isDeleted;
  }

  public Radnomjesto(long radnoMjestoId, String imeRadnogMjesta, double satnica) {
    this.radnoMjestoId = radnoMjestoId;
    this.imeRadnogMjesta = imeRadnogMjesta;
    this.satnica = satnica;
  }

  public Radnomjesto(String imeRadnogMjesta, double satnica) {
    this.imeRadnogMjesta = imeRadnogMjesta;
    this.satnica = satnica;
  }


  public long getRadnoMjestoId() {
    return radnoMjestoId;
  }

  public void setRadnoMjestoId(long radnoMjestoId) {
    this.radnoMjestoId = radnoMjestoId;
  }


  public String getImeRadnogMjesta() {
    return imeRadnogMjesta;
  }

  public void setImeRadnogMjesta(String imeRadnogMjesta) {
    this.imeRadnogMjesta = imeRadnogMjesta;
  }


  public double getSatnica() {
    return satnica;
  }

  public void setSatnica(double satnica) {
    this.satnica = satnica;
  }

  public String getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(String isDeleted) {
    this.isDeleted = isDeleted;
  }

  public static ObservableList<Radnomjesto> getWorkplaces(){
    ObservableList<Radnomjesto> workplaces = FXCollections.observableArrayList();
    Baza db = new Baza();
    PreparedStatement ps = db.exec("SELECT rm.RadnoMjestoID, rm.ImeRadnogMjesta, rm.Satnica FROM radnomjesto rm WHERE IsDeleted=0");
    try{
      ResultSet rs= ps.executeQuery();
      while (rs.next()) {
        workplaces.add(new Radnomjesto(
                rs.getLong("RadnoMjestoID"),
                rs.getString("ImeRadnogMjesta"),
                rs.getDouble("Satnica")
        ));
      }

    } catch (SQLException ex) {
      System.out.println("Nastala je SQL greška: " + ex);

    }
    return workplaces;
  }

  public static ObservableList<String> getWorkplaceNames(){
    ObservableList<String> workplaces = FXCollections.observableArrayList();

    Baza db = new Baza();
    PreparedStatement ps = db.exec("SELECT rm.ImeRadnogMjesta FROM radnomjesto rm WHERE IsDeleted=0");
    try{
      ResultSet rs= ps.executeQuery();
      while (rs.next()) {
        workplaces.add(
                rs.getString("ImeRadnogMjesta")
        );
      }

    } catch (SQLException ex) {
      System.out.println("Nastala je SQL greška: " + ex);

    }
    return workplaces;

  }

  public static ObservableList<Radnomjesto> getDeletedWorkplaces(){
    ObservableList<Radnomjesto> workplaces = FXCollections.observableArrayList();
    Baza db = new Baza();
    PreparedStatement ps = db.exec("SELECT rm.RadnoMjestoID, rm.ImeRadnogMjesta, rm.Satnica FROM radnomjesto rm WHERE IsDeleted=1");
    try{
      ResultSet rs= ps.executeQuery();
      while (rs.next()) {
        workplaces.add(new Radnomjesto(
                rs.getLong("RadnoMjestoID"),
                rs.getString("ImeRadnogMjesta"),
                rs.getDouble("Satnica")
        ));
      }

    } catch (SQLException ex) {
      System.out.println("Nastala je SQL greška: " + ex);

    }
    return workplaces;
  }

  // soft delete workplace
  public void deleteWorkplace(long id){
    try {
      String sql = "UPDATE radnomjesto SET IsDeleted = 1 WHERE RadnoMjestoID = " + String.valueOf(id);
      Baza DB = new Baza();
      PreparedStatement upit = DB.exec (sql);

      upit.executeUpdate();
    }catch (SQLException ex){
      System.out.print("Nastala je SQL greška: " + ex);
    }
  }

  // restore deleted workplace
  public void restoreWorkplace(long id){
    try {
      String sql = "UPDATE radnomjesto SET IsDeleted = 0 WHERE RadnoMjestoID = " + String.valueOf(id);
      Baza DB = new Baza();
      PreparedStatement upit = DB.exec (sql);

      upit.executeUpdate();
    }catch (SQLException ex){
      System.out.print("Nastala je SQL greška: " + ex);
    }
  }

  // create new workplace
  public void createWorkplace(){
    try {
      String sql = "INSERT INTO radnomjesto VALUES (null, ?, ?, 0)";
      Baza DB = new Baza();
      PreparedStatement upit = DB.exec (sql);
      upit.setString(1, this.imeRadnogMjesta);
      upit.setDouble(2, this.satnica);
      upit.executeUpdate();

    } catch (SQLException ex) {
      System.out.print("SQL greška" + ex);
    }
  }

}
