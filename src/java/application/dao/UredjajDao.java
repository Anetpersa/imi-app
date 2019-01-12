
package application.dao;

import application.domains.Uredjaj;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UredjajDao {
    
    public void startSession();
    
    public void stopSession();
    
    public boolean dodajUredjaj(Uredjaj uredjaj);
    
    public List<Uredjaj> listaUredjaja();
    
    public Uredjaj pronadjiUredjaj(int id);
    
    public void promeniUredjaj(Uredjaj uredjaj);
    
    public void obrisiUredjaj(Uredjaj uredjaj);
}
