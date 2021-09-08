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

  public Radnomjesto(long radnoMjestoId, String imeRadnogMjesta, double satnica) {
    this.radnoMjestoId = radnoMjestoId;
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

  public static ObservableList<Radnomjesto> getWorkplaces(){
    ObservableList<Radnomjesto> workplaces = FXCollections.observableArrayList();
    Baza db = new Baza();
    PreparedStatement ps = db.exec("SELECT rm.RadnoMjestoID, rm.ImeRadnogMjesta, rm.Satnica FROM radnomjesto rm ");
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

}
