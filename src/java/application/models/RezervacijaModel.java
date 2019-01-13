package application.models;

import java.util.Date;

public class RezervacijaModel {

    private int id;
    private String datum;
    private IstrazivacModel istrazivacModel;
    private UredjajModel uredjajModel;
    private String parametar;
    private int idIstrazivaca;
    private int idUredjaja;

    public RezervacijaModel(int id, String datum, IstrazivacModel istrazivacModel, UredjajModel uredjajModel, String parametar) {
        this.id = id;
        this.datum = datum;
        this.istrazivacModel = istrazivacModel;
        this.uredjajModel = uredjajModel;
        this.parametar = parametar;
    }

    public RezervacijaModel(String datum, IstrazivacModel istrazivacModel, UredjajModel uredjajModel, String parametar) {
        this.datum = datum;
        this.istrazivacModel = istrazivacModel;
        this.uredjajModel = uredjajModel;
        this.parametar = parametar;
    }

    public RezervacijaModel() {
    }

    public RezervacijaModel(String datum, String parametar, int idIstrazivaca, int idUredjaja) {
        this.datum = datum;
        this.parametar = parametar;
        this.idIstrazivaca = idIstrazivaca;
        this.idUredjaja = idUredjaja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
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

    public int getIdIstrazivaca() {
        return idIstrazivaca;
    }

    public void setIdIstrazivaca(int idIstrazivaca) {
        this.idIstrazivaca = idIstrazivaca;
    }

    public int getIdUredjaja() {
        return idUredjaja;
    }

    public void setIdUredjaja(int idUredjaja) {
        this.idUredjaja = idUredjaja;
    }

}
