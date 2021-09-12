package app.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Role {

  private long roleId;
  private String rola;


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getRola() {
    return rola;
  }

  public void setRola(String rola) {
    this.rola = rola;
  }

  public static ObservableList<String> getRoleNames(){

    ObservableList<String> roles = FXCollections.observableArrayList();

    Baza db = new Baza();
    PreparedStatement ps = db.exec("SELECT r.Rola as ImeRole FROM role r");
    try{
      ResultSet rs= ps.executeQuery();
      while (rs.next()) {
        roles.add(
                rs.getString("ImeRole")
        );
      }

    } catch (SQLException ex) {
      System.out.println("Nastala je SQL greška: " + ex);

    }
    return roles;

  }

}
