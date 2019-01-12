
package application.services.impl;

import application.dao.RezervacijaDao;
import application.domains.Rezervacija;
import application.models.RezervacijaModel;
import application.services.RezervacijaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class RezervacijaServiceImpl implements RezervacijaService{
    
@Autowired
    RezervacijaDao rezervacijaDao;

    public RezervacijaDao getRezervacijaDao() {
        return rezervacijaDao;
    }

    public void setRezervacijaDao(RezervacijaDao rezervacijaDao) {
        this.rezervacijaDao = rezervacijaDao;
    }

    @Override
    @Transactional
    public boolean dodajRezervaciju(RezervacijaModel novaRezervacija) {
 
        if (novaRezervacija != null) {
            Rezervacija rezervacija = new Rezervacija(novaRezervacija.getNaziv(), novirezervacija.getLab());
            if (novirezervacija.getNaziv() != null) {
                rezervacija.setNaziv(novirezervacija.getNaziv());
            }
            rezervacijaDao.startSession();
            rezervacijaDao.dodajrezervacija(rezervacija);
            rezervacijaDao.stopSession();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<rezervacijaModel> listarezervacijaa() {

        List<rezervacijaModel> rezervacijaiModel = new ArrayList<>();

        rezervacijaDao.startSession();
        List<rezervacija> rezervacijai = rezervacijaDao.listarezervacijaa();
        rezervacijaDao.stopSession();
        for (rezervacija rezervacija : rezervacijai) {
            rezervacijaiModel.add(new rezervacijaModel(rezervacija.getId(), rezervacija.getNaziv(), rezervacija.getLab()));
        }
        return rezervacijaiModel;
    }

    @Override
    public rezervacijaModel pronadjirezervacija(int id) {
        
        rezervacijaDao.startSession();
        rezervacija rezervacija = rezervacijaDao.pronadjirezervacija(id);
        
        rezervacijaModel rezervacijaModel = new rezervacijaModel(rezervacija.getId(), rezervacija.getNaziv(), rezervacija.getLab());
        rezervacijaDao.stopSession();
        return rezervacijaModel;
    }

    @Override
    public void promenirezervacija(rezervacijaModel promenjenrezervacija) {
        rezervacijaDao.startSession();
        rezervacija rezervacija = rezervacijaDao.pronadjirezervacija(promenjenrezervacija.getId());
        rezervacija.setNaziv(promenjenrezervacija.getNaziv());
        rezervacija.setLab(promenjenrezervacija.getLab());
                
        if (promenjenrezervacija.getNaziv() != null) {
            rezervacija.setNaziv(promenjenrezervacija.getNaziv());
        }
        rezervacijaDao.promenirezervacija(rezervacija);
        rezervacijaDao.stopSession();
    }

    @Override
    public void obrisirezervacija(rezervacijaModel obrisanrezervacija) {
        rezervacijaDao.startSession();
        rezervacija rezervacija = rezervacijaDao.pronadjirezervacija(obrisanrezervacija.getId());
        rezervacijaDao.obrisirezervacija(rezervacija);
        rezervacijaDao.stopSession();
    }

}
