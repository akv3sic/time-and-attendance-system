package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersInfoModel {
    SimpleIntegerProperty userID;
    SimpleStringProperty userName;
    SimpleStringProperty userLastName;
    SimpleStringProperty jobTitle;

    public UsersInfoModel(Integer userID, String userName, String userLastName, String jobTitle){
        this.userID= new SimpleIntegerProperty(userID);
        this.userName=new SimpleStringProperty(userName);
        this.userLastName=new SimpleStringProperty(userLastName);
        this.jobTitle=new SimpleStringProperty(jobTitle);
    }

    public int getUserID() {
        return userID.get();
    }

    public String getUserName() {
        return userName.get();
    }

    public String getUserLastName() {
        return userLastName.get();
    }

    public String getJobTitle() {
        return jobTitle.get();
    }

    public static ObservableList<UsersInfoModel> getUsersInfo(){
        ObservableList<UsersInfoModel> usersList = FXCollections.observableArrayList();
        Baza db = new Baza();
        PreparedStatement ps = db.exec("SELECT k.Ime as userName," +
                "\tk.Prezime as userLastName,\n" +
                "    k.KorisnikID as userID,\n" +
                "    r.ImeRadnogMjesta as jobTitle\n" +
                "\n" +
                "FROM korisnici as k \n" +
                "INNER JOIN\n" +
                "\tradnomjesto as r\n" +
                "\n" +
                "\n" +
                "WHERE k.RadnoMjestoID = r.RadnoMjestoID;");
        try{
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("userID"));

                        usersList.add(new UsersInfoModel(
                        rs.getInt("userID"),
                        rs.getString("userName"),
                        rs.getString("userLastName"),
                        rs.getString("jobTitle")));

            }
        } catch (SQLException ex) {
            System.out.println("Nastala je greška prilikom iteriranja.");

            }
        return usersList;
        }

    }




