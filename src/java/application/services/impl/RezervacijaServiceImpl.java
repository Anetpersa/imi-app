package application.services.impl;

import application.dao.IstrazivacDao;
import application.dao.RezervacijaDao;
import application.dao.UredjajDao;
import application.domains.Istrazivac;
import application.domains.Rezervacija;
import application.domains.Uredjaj;
import application.models.IstrazivacModel;
import application.models.RezTranzModel;
import application.models.RezervacijaModel;
import application.models.UredjajModel;
import application.services.IstrazivacService;
import application.services.RezervacijaService;
import application.services.UredjajService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RezervacijaServiceImpl implements RezervacijaService {

    @Autowired
    RezervacijaDao rezervacijaDao;

    public RezervacijaDao getRezervacijaDao() {
        return rezervacijaDao;
    }

    public void setRezervacijaDao(RezervacijaDao rezervacijaDao) {
        this.rezervacijaDao = rezervacijaDao;
    }

    @Autowired
    IstrazivacDao istrazivacDao;

    public IstrazivacDao getIstrazivacDao() {
        return istrazivacDao;
    }

    public void setIstrazivacDao(IstrazivacDao istrazivacDao) {
        this.istrazivacDao = istrazivacDao;
    }

    @Autowired
    UredjajDao uredjajDao;

    public UredjajDao getUredjajDao() {
        return uredjajDao;
    }

    public void setUredjajDao(UredjajDao uredjajDao) {
        this.uredjajDao = uredjajDao;
    }

    @Autowired
    IstrazivacService istrazivacService;

    public IstrazivacService getIstrazivacService() {
        return istrazivacService;
    }

    public void setIstrazivacService(IstrazivacService istrazivacService) {
        this.istrazivacService = istrazivacService;
    }

    @Autowired
    UredjajService uredjajService;

    public UredjajService getUredjajService() {
        return uredjajService;
    }

    public void setUredjajService(UredjajService uredjajService) {
        this.uredjajService = uredjajService;
    }

    @Override
    public Date KonverzijaDatumaIzStringaUDate(String datum) throws ParseException {
        String dateFormat = "yyyy-MM-dd";       //ovo mora da bude tacno ovako inace izbacuje januar uvek
        SimpleDateFormat sdf1 = new SimpleDateFormat(dateFormat);

        Date formattedDate = sdf1.parse(datum);
        return formattedDate;
    }

    @Override
    public String KonverzijaDatumaIzDateUString(Date datum) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateString = sdf2.format(datum);
        return currentDateString;
    }

    @Override
    @Transactional
    public boolean dodajRezervaciju(RezTranzModel novaRezervacija) throws ParseException {

        if (novaRezervacija != null) {
            Date parsiranDatum = KonverzijaDatumaIzStringaUDate(novaRezervacija.getDatum());
            Rezervacija rezervacija = new Rezervacija(parsiranDatum, istrazivacDao.pronadjiIstrazivaca(novaRezervacija.getIdIstrazivaca()),
                    uredjajDao.pronadjiUredjaj(novaRezervacija.getIdUredjaja()), novaRezervacija.getParametar());
            rezervacijaDao.startSession();
            rezervacijaDao.dodajRezervaciju(rezervacija);
            rezervacijaDao.stopSession();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<RezervacijaModel> listaRezervacija() {

        List<RezervacijaModel> rezervacijeModel = new ArrayList<>();

        rezervacijaDao.startSession();
        List<Rezervacija> rezervacije = rezervacijaDao.listaRezervacija();
        rezervacijaDao.stopSession();
        for (Rezervacija rezervacija : rezervacije) {
            rezervacijeModel.add(new RezervacijaModel(rezervacija.getId(), KonverzijaDatumaIzDateUString(rezervacija.getDatum()),
                    istrazivacService.pronadjiIstrazivaca(rezervacija.getId()), uredjajService.pronadjiUredjaj(rezervacija.getId()), rezervacija.getParametar()));
        }
        return rezervacijeModel;
    }

    @Override
    public RezervacijaModel pronadjiRezervaciju(int id) {

        rezervacijaDao.startSession();
        Rezervacija rezervacija = rezervacijaDao.pronadjiRezervaciju(id);

        RezervacijaModel rezervacijaModel = new RezervacijaModel(KonverzijaDatumaIzDateUString(rezervacija.getDatum()),
                istrazivacService.pronadjiIstrazivaca(rezervacija.getId()), uredjajService.pronadjiUredjaj(rezervacija.getId()), rezervacija.getParametar());
        rezervacijaDao.stopSession();
        return rezervacijaModel;
    }

    @Override
    public void promeniRezervaciju(RezervacijaModel promenjenaRezervacija) {
        try {
            rezervacijaDao.startSession();
            Rezervacija rezervacija = rezervacijaDao.pronadjiRezervaciju(promenjenaRezervacija.getId());
            rezervacija.setDatum(KonverzijaDatumaIzStringaUDate(promenjenaRezervacija.getDatum()));
            rezervacija.setParametar(promenjenaRezervacija.getParametar());

            if (promenjenaRezervacija.getDatum() != null) {
                rezervacija.setDatum(KonverzijaDatumaIzStringaUDate(promenjenaRezervacija.getDatum()));
            }
            rezervacijaDao.promeniRezervaciju(rezervacija);
            rezervacijaDao.stopSession();
        } catch (ParseException ex) {
            Logger.getLogger(RezervacijaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void obrisiRezervaciju(RezervacijaModel obrisanaRezervacija) {
        rezervacijaDao.startSession();
        Rezervacija rezervacija = rezervacijaDao.pronadjiRezervaciju(obrisanaRezervacija.getId());
        rezervacijaDao.obrisiRezervaciju(rezervacija);
        rezervacijaDao.stopSession();
    }

}
