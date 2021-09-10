package sample.helpers;

import sample.model.Baza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

public class Rfid {
    private String cardID;
    private long userID;
    private Date date;
    private Time time;

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Rfid(String cardID) {
        this.cardID = cardID;
    }

    public boolean isCardRegistered() throws SQLException {
        boolean validity = true;
        Baza db = new Baza();
        PreparedStatement ps = db.exec("SELECT k.Ime, k.Prezime, k.KorisnikID\n" +
                "FROM korisnici as k\n" +
                "WHERE k.CardID = ?");
        ps.setString(1, this.cardID.substring(0,10));
        try{
            ResultSet rs= ps.executeQuery();
            if(!rs.isBeforeFirst()) {
                validity = false;
            }
            else {
                rs.next();
                setUserID(rs.getLong("KorisnikID"));
                System.out.println("ID korisnika: " + this.userID);
            }


        } catch (SQLException ex) {
            System.out.println("Nastala je SQL greška: " + ex);
            System.out.println(this.cardID);
        }

       return validity;
    }
}
