package application.domains;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "rezervacija")
public class Rezervacija implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rezervacije")
    private int id;

    @Column(name = "datum")
    private Date datum;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_istrazivaca")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Istrazivac istrazivac; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_uredjaja")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Uredjaj uredjaj;
    
    @Column(name = "parametar")
    private String parametar;

    public Rezervacija(int id, Date datum, Istrazivac istrazivac, Uredjaj uredjaj, String parametar) {
        this.id = id;
        this.datum = datum;
        this.istrazivac = istrazivac;
        this.uredjaj = uredjaj;
        this.parametar = parametar;
    }

    public Rezervacija(Date datum, Istrazivac istrazivac, Uredjaj uredjaj, String parametar) {
        this.datum = datum;
        this.istrazivac = istrazivac;
        this.uredjaj = uredjaj;
        this.parametar = parametar;
    }

    public Rezervacija() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Istrazivac getIstrazivac() {
        return istrazivac;
    }

    public void setIstrazivac(Istrazivac istrazivac) {
        this.istrazivac = istrazivac;
    }

    public Uredjaj getUredjaj() {
        return uredjaj;
    }

    public void setUredjaj(Uredjaj uredjaj) {
        this.uredjaj = uredjaj;
    }

    public String getParametar() {
        return parametar;
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
    }

    
}