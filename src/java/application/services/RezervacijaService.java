
package application.services;

import application.models.RezTranzModel;
import application.models.RezervacijaModel;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface RezervacijaService {
    public Date KonverzijaDatumaIzStringaUDate(String datum) throws ParseException;
    
    public String KonverzijaDatumaIzDateUString(Date datum);
    
    public boolean dodajRezervaciju(RezTranzModel novaRezervacija) throws ParseException;
    
    public List<RezervacijaModel> listaRezervacija();
    
    public RezervacijaModel pronadjiRezervaciju(int id);

    public void promeniRezervaciju(RezTranzModel promenjenaRezervacija);

    public void obrisiRezervaciju(RezervacijaModel obrisanaRezervacija); 
}
