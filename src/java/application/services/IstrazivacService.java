
package application.services;

import application.models.IstrazivacModel;
import java.util.List;

public interface IstrazivacService {
   
    public boolean dodajIstrazivaca(IstrazivacModel noviIstrazivac);
    
    public List<IstrazivacModel> listaIstrazivaca();
    
    public IstrazivacModel pronadjiIstrazivaca(int id);

    public void promeniIstrazivaca(IstrazivacModel promenjenIstrazivac);

    public void obrisiIstrazivaca(IstrazivacModel obrisanIstrazivac); 
}
