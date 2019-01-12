
package application.models;

public class UredjajModel {
    private int id;
    private String naziv;
    private String lab;

    public UredjajModel(int id, String naziv, String lab) {
        this.id = id;
        this.naziv = naziv;
        this.lab = lab;
    }

    public UredjajModel(String naziv, String lab) {
        this.naziv = naziv;
        this.lab = lab;
    }

    public UredjajModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }
    
    
}
