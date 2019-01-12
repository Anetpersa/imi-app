
package application.services;

import application.models.UredjajModel;
import java.util.List;

public interface UredjajService {
    public boolean dodajUredjaj(UredjajModel noviUredjaj);
    
    public List<UredjajModel> listaUredjaja();
    
    public UredjajModel pronadjiUredjaj(int id);

    public void promeniUredjaj(UredjajModel promenjenUredjaj);

    public void obrisiUredjaj(UredjajModel obrisanUredjaj); 
}
