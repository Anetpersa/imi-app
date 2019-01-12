package application.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "istrazivac")
public class Istrazivac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_korisnika")
    private int id;

    @Column(name = "ime_prezime")
    private String imePrezime;

    @Column(name = "grupa")
    private String istrazivackaGrupa;

    @Column(name = "email")
    private String email;

    @Column(name = "sifra")
    private String sifra;

    public Istrazivac(int id, String imePrezime, String istrazivackaGrupa, String email, String sifra) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.istrazivackaGrupa = istrazivackaGrupa;
        this.email = email;
        this.sifra = sifra;
    }

    public Istrazivac(String imePrezime, String istrazivackaGrupa, String email, String sifra) {
        this.imePrezime = imePrezime;
        this.istrazivackaGrupa = istrazivackaGrupa;
        this.email = email;
        this.sifra = sifra;
    }

    public Istrazivac() {
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
