package application.models;

import java.text.SimpleDateFormat;

public class RezTranzModel {

    private Integer id;
    private Integer idIstrazivaca;
    private Integer idUredjaja;
    private String parametar;
    private String datum;

    public RezTranzModel(Integer idIstrazivaca, Integer idUredjaja, String parametar, String datum) {
        this.idIstrazivaca = idIstrazivaca;
        this.idUredjaja = idUredjaja;
        this.parametar = parametar;
        this.datum = datum;
    }

    public RezTranzModel(Integer idUredjaja) {
        this.idUredjaja = idUredjaja;
    }

    public RezTranzModel() {
    }
    
    public RezTranzModel(RezervacijaModel rezervacija) {
        this.id = rezervacija.getId();
        this.idIstrazivaca = rezervacija.getIstrazivacModel().getId();
        this.idUredjaja = rezervacija.getUredjajModel().getId();
        this.parametar = rezervacija.getParametar();
        this.datum = rezervacija.getDatum();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdIstrazivaca() {
        return idIstrazivaca;
    }

    public void setIdIstrazivaca(Integer idIstrazivaca) {
        this.idIstrazivaca = idIstrazivaca;
    }

    public Integer getIdUredjaja() {
        return idUredjaja;
    }

    public void setIdUredjaja(Integer idUredjaja) {
        this.idUredjaja = idUredjaja;
    }

    public String getParametar() {
        return parametar;
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    
}