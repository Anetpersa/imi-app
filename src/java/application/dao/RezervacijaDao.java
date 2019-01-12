package application.dao;

import application.domains.Rezervacija;
import java.util.List;

public interface RezervacijaDao {

    public void startSession();

    public void stopSession();

    public boolean dodajRezervaciju(Rezervacija rezervacija);

    public List<Rezervacija> listaRezervacija();

    public Rezervacija pronadjiRezervaciju(int id);

    public void promeniRezervaciju(Rezervacija rezervacija);

    public void obrisiRezervaciju(Rezervacija rezervacija);
}
