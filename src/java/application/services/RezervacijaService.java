
package application.services;

import application.models.RezervacijaModel;
import java.util.List;

public interface RezervacijaService {
    public boolean dodajRezervaciju(RezervacijaModel novaRezervacija);
    
    public List<RezervacijaModel> listaRezervacija();
    
    public RezervacijaModel pronadjiRezervaciju(int id);

    public void promeniRezervaciju(RezervacijaModel promenjenaRezervacija);

    public void obrisiRezervaciju(RezervacijaModel obrisanaRezervacija); 
}
