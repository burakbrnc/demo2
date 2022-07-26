package javapart;

public class Kullanici {

    int id;
    String kullanici;
    String sifre;
    String email;

    public Kullanici() {
    }

    public Kullanici(int id, String kullanici, String sifre, String email) {
        this.id = id;
        this.kullanici = kullanici;
        this.sifre = sifre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

