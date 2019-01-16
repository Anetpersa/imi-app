
package application.models;

import javax.validation.constraints.Size;

public class UredjajModel {
    private int id;
    
    @Size(min = 5, max = 50, message = "Naziv uredjaja mora imati minimum 5 i maksimum 50 karaktera.")
    private String naziv;
    
    @Size(min = 2, max = 20, message = "Naziv laboratorije mora imati minimum 2 i maksimum 20 karaktera.")
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
