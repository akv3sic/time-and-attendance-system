package sample.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoggedInModel {
    public int userID;
    public String userName;
    public boolean isLogged;
    public boolean isAdmin;

    public LoggedInModel(int userID, String userName, boolean isLogged, boolean isAdmin){
        this.userID=userID;
        this.userName=userName;
        this.isLogged=isLogged;
        this.isAdmin=isAdmin;
    }

    public static LoggedInModel login(String email, String pass){
        Baza db = new Baza();
        PreparedStatement ps = db.exec("Select k.Ime as name, k.KorisnikID as userID, r.Rola as rola from korisnici as k inner join role as r where k.RoleID=r.RoleID AND k.Email =? AND k.Password =?");
        LoggedInModel user=new LoggedInModel(0, "", false, false);
        try{
            ps.setString(1, email);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int m = rs.getInt("userID");
            String name = rs.getString("name");
            String rola=rs.getString("rola");
            System.out.println(name);
            System.out.println(rola);
            System.out.println(m);

            if (m!=0){

                user.isLogged=true;
                user.userName=rs.getString("name");
                user.userID=rs.getInt("userID");

            }
            if ((rs.getString("rola").equals("Superadmin"))||(rs.getString("rola").equals("Admin"))){

                user.isAdmin=true;
            }

            return user;





        }
        catch (SQLException ex){
            System.out.println("Nastala je greška: "+ex.getMessage());
            return user;
        }
    }
}
