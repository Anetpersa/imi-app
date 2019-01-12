
package application.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="uredjaj")
public class Uredjaj {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uredjaja")
    private int id;
    
    @Column(name="naziv")
    private String naziv;
    
    @Column(name="lab")
    private String lab;

    public Uredjaj(int id, String naziv, String lab) {
        this.id = id;
        this.naziv = naziv;
        this.lab = lab;
    }

    public Uredjaj(String naziv, String lab) {
        this.naziv = naziv;
        this.lab = lab;
    }

    public Uredjaj() {
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
