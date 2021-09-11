package sample.helpers;

import sample.model.Baza;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Rfid {
    private String cardID;
    private long userID;
    private Date date;
    private Time time;
    private Short inOut;

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    private long recordId;

    public void setInOut(Short inOut) {
        this.inOut = inOut;
    }

    Baza db = new Baza();
    PreparedStatement ps;

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Rfid(String cardID) {
        this.cardID = cardID;
        this.time = Time.valueOf(LocalTime.now());
        this.date = Date.valueOf(LocalDate.now());
    }

    public boolean isCardRegistered() throws SQLException {
        boolean validity = true;
        ps = db.exec("SELECT k.Ime, k.Prezime, k.KorisnikID\n" +
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

    public void saveRecord() throws SQLException {
        System.out.println("Save record entered");
        String lastRecord = checkLastRecord();
        if(lastRecord == "In") {
            System.out.println("Upiši kao OUT");
            writeRecord("Out");
        }
        else {
            System.out.println("Upiši kao IN");
            writeRecord("In");
        }
    }

    private void writeRecord(String inOut) throws SQLException {
        if(inOut == "In") {
            ps = db.exec("INSERT INTO evidencijarada VALUES (null, ?, null, ?, null, null, ?, null, ?)");
            ps.setTime(1, this.time);
            ps.setDate(2, this.date);
            ps.setLong(3, this.userID);
            ps.setShort(4, (short) 1);
        }
        else {
            ps = db.exec("UPDATE evidencijarada t SET t.VrijemeKraja = ?, t.`InOut` = 0 WHERE t.EvidencijaID = ?");
            ps.setTime(1, this.time);
            ps.setLong(2, this.recordId);
        }
        ps.execute();
    }

    private String checkLastRecord() throws SQLException {
        ps = db.exec("SELECT e.`InOut`, e.EvidencijaID\n" +
                "FROM evidencijarada as e\n" +
                "WHERE e.KorisnikID = ?\n" +
                "ORDER BY e.EvidencijaID DESC LIMIT 1");
        ps.setLong(1, this.userID);

        try{
            ResultSet rs= ps.executeQuery();
            if(!rs.isBeforeFirst()) {
                return null;
            }
            else {
                rs.next();
                setInOut(rs.getShort("InOut"));
                if(this.inOut == 1) {
                    setRecordId(rs.getLong("EvidencijaID"));
                    return "In";
                }
            }


        } catch (SQLException ex) {
            System.out.println("Nastala je SQL greška: " + ex);
            System.out.println(this.cardID);
        }
        return null;
    }
}
