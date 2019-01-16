package application.models;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class IstrazivacModel {

    private int id;
    
    @Size(min = 5, max = 50, message = "Ime i prezime istrazivaca ne smeju biti kraci od 5 i duzi od 50 karaktera.")
    private String imePrezime;
    
    @Size(min = 5, max = 50, message = "Naziv istrazivacke grupe ne sme biti krace od 5 i duze od 50 karaktera.")
    private String istrazivackaGrupa;
    
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@imi.bg.ac.rs", message="Unesite validnu IMIjevsku email adresu: @imi.bg.ac.rs")
    private String email;
    
    @Size(min = 6,max = 20,message="Sifra treba da bude duga minimum 5, a maksimum 20 karaktera.")
    private String sifra;

    public IstrazivacModel(int id, String imePrezime, String istrazivackaGrupa, String email, String sifra) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.istrazivackaGrupa = istrazivackaGrupa;
        this.email = email;
        this.sifra = sifra;
    }

    public IstrazivacModel(String imePrezime, String istrazivackaGrupa, String email, String sifra) {
        this.imePrezime = imePrezime;
        this.istrazivackaGrupa = istrazivackaGrupa;
        this.email = email;
        this.sifra = sifra;
    }

    public IstrazivacModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getIstrazivackaGrupa() {
        return istrazivackaGrupa;
    }

    public void setIstrazivackaGrupa(String istrazivackaGrupa) {
        this.istrazivackaGrupa = istrazivackaGrupa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

}