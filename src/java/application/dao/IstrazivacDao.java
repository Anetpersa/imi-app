
package application.dao;

import application.domains.Istrazivac;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IstrazivacDao {
    
    public void startSession();
    
    public void stopSession();
    
    public boolean dodajIstrazivaca(Istrazivac istrazivac);
    
    public List<Istrazivac> listaIstrazivaca();
    
    public Istrazivac pronadjiIstrazivaca(int id);
    
    public void promeniIstrazivaca(Istrazivac istrazivac);
    
    public void obrisiIstrazivaca(Istrazivac istrazivac);
}
