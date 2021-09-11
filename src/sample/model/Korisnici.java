package sample.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Korisnici {

  private String ime;
  private String prezime;
  private String kontaktBroj;
  private String role;
  private String radnoMjesto;
  private String password;
  private String email;
  private String rfid;

  public Korisnici(){

  }

  public Korisnici(String ime, String prezime, String kontaktBroj, String role, String radnoMjesto, String password, String email, String rfid){
    this.ime=ime;
    this.prezime=prezime;
    this.kontaktBroj=kontaktBroj;
    this.role=role;
    this.radnoMjesto=radnoMjesto;
    this.password=password;
    this.email=email;
    this.rfid=rfid;

  }

  public static Korisnici getUser(int id){

    try{
      Baza db = new Baza();
      PreparedStatement ps = db.exec("SELECT k.Ime as name, k.Prezime as lastName, k.KontaktBroj as phone," +
              " k.Password as pass, k.Email as mail, k.CardID as rfid, rm.ImeRadnogMjesta as workplace, " +
              "r.Rola as role FROM korisnici as k inner join radnomjesto as rm " +
              "INNER join role as r WHERE k.KorisnikID = "+ id +" and k.RoleID=r.RoleID " +
              "and k.RadnoMjestoID=rm.RadnoMjestoID; ");
      ResultSet rs = ps.executeQuery();
      rs.next();
      Korisnici user = new Korisnici(
              rs.getString("name"),
              rs.getString("lastName"),
              rs.getString("phone"),
              rs.getString("role"),
              rs.getString("workplace"),
              rs.getString("pass"),
              rs.getString("mail"),
              rs.getString("rfid")

      );
      return user;



    }
    catch (SQLException ex){
      Korisnici user = new Korisnici();
      System.out.println("Nastala je greška: "+ex.getMessage());
      return user;

    }


  }

  public static void addUser(Korisnici user){
    try {
      Baza db = new Baza();
      PreparedStatement ps = db.exec("INSERT INTO korisnici (Ime , Prezime, KontaktBroj,  RoleID, RadnoMjestoID, CardID, korisnici.Password, Email ) " +
              "VALUES (?, ?, ?, (SELECT role.RoleID from role WHERE role.Rola= ?), " +
              "(SELECT radnomjesto.RadnoMjestoID from radnomjesto WHERE radnomjesto.ImeRadnogMjesta= ?), ?, ?,?);");
      ps.setString(1, user.ime);
      ps.setString(2,user.prezime);
      ps.setString(3,user.kontaktBroj);
      ps.setString(4,user.role);
      ps.setString(5,user.radnoMjesto);
      ps.setString(6,user.rfid);
      ps.setString(7,user.password);
      ps.setString(8,user.email);
      ps.executeUpdate();
    }
    catch (Exception e){
      System.out.print("Nastala je SQL greška: " + e);
    }


  }


  public static void updateUser(Korisnici user, int id){
    try {
      Baza db = new Baza();
      PreparedStatement ps = db.exec("UPDATE korisnici as k \n" +
              "Set k.Ime =?, k.Prezime=?, k.KontaktBroj = ?, k.RoleID=(SELECT role.RoleID from role WHERE role.Rola= ?), k.RadnoMjestoID=(SELECT radnomjesto.RadnoMjestoID from radnomjesto WHERE radnomjesto.ImeRadnogMjesta= ?), k.CardID=?, k.Password=?, k.Email=?\n" +
              "WHERE k.KorisnikID = ?;");
      ps.setString(1, user.ime);
      ps.setString(2,user.prezime);
      ps.setString(3,user.kontaktBroj);
      ps.setString(4,user.role);
      ps.setString(5,user.radnoMjesto);
      ps.setString(6,user.rfid);
      ps.setString(7,user.password);
      ps.setString(8,user.email);
      ps.setInt(9, id);
      ps.executeUpdate();
    }
    catch (Exception e){
      System.out.print("Nastala je SQL greška: " + e);
    }
  }








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


  public String getKontaktBroj() {
    return kontaktBroj;
  }

  public void setKontaktBroj(String kontaktBroj) {
    this.kontaktBroj = kontaktBroj;
  }








  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getRadnoMjesto() {
    return radnoMjesto;
  }

  public void setRadnoMjesto(String radnoMjesto) {
    this.radnoMjesto = radnoMjesto;
  }

  public String getRfid(){return rfid;}

  public void setRfid(String rfid) {
    this.rfid = rfid;
  }
}
