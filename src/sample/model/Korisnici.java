package sample.model;


public class Korisnici {

  private long korisnikId;
  private String ime;
  private String prezime;
  private String kontaktBroj;
  private long roleId;
  private long radnoMjestoId;
  private String password;
  private String email;


  public long getKorisnikId() {
    return korisnikId;
  }

  public void setKorisnikId(long korisnikId) {
    this.korisnikId = korisnikId;
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


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public long getRadnoMjestoId() {
    return radnoMjestoId;
  }

  public void setRadnoMjestoId(long radnoMjestoId) {
    this.radnoMjestoId = radnoMjestoId;
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

}
