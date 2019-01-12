package application.models;

import java.util.Date;

public class RezervacijaModel {

    private int id;
    private Date datum;
    private IstrazivacModel istrazivacModel;
    private UredjajModel uredjajModel;
    private String parametar;

    public RezervacijaModel(int id, Date datum, IstrazivacModel istrazivacModel, UredjajModel uredjajModel, String parametar) {
        this.id = id;
        this.datum = datum;
        this.istrazivacModel = istrazivacModel;
        this.uredjajModel = uredjajModel;
        this.parametar = parametar;
    }

    public RezervacijaModel(Date datum, IstrazivacModel istrazivacModel, UredjajModel uredjajModel, String parametar) {
        this.datum = datum;
        this.istrazivacModel = istrazivacModel;
        this.uredjajModel = uredjajModel;
        this.parametar = parametar;
    }

    public RezervacijaModel() {
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

    public IstrazivacModel getIstrazivacModel() {
        return istrazivacModel;
    }

    public void setIstrazivacModel(IstrazivacModel istrazivacModel) {
        this.istrazivacModel = istrazivacModel;
    }

    public UredjajModel getUredjajModel() {
        return uredjajModel;
    }

    public void setUredjajModel(UredjajModel uredjajModel) {
        this.uredjajModel = uredjajModel;
    }

    public String getParametar() {
        return parametar;
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
    }

    

}
