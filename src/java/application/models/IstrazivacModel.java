package application.models;

public class IstrazivacModel {

    private int id;
    private String imePrezime;
    private String istrazivackaGrupa;
    private String email;
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