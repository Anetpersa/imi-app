
package application.models;

public class RezTranzModel {
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

    public RezTranzModel() {
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