package application.services.impl;

import application.dao.IstrazivacDao;
import application.domains.Istrazivac;
import application.models.IstrazivacModel;
import application.services.IstrazivacService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IstrazivacServiceImpl implements IstrazivacService {

    @Autowired
    IstrazivacDao istrazivacDao;

    public IstrazivacDao getIstrazivacDao() {
        return istrazivacDao;
    }

    public void setIstrazivacDao(IstrazivacDao istrazivacDao) {
        this.istrazivacDao = istrazivacDao;
    }

    @Override
    @Transactional
    public boolean dodajIstrazivaca(IstrazivacModel noviIstrazivac) {

        if (noviIstrazivac != null) {
            Istrazivac istrazivac = new Istrazivac(noviIstrazivac.getImePrezime(), noviIstrazivac.getIstrazivackaGrupa(), noviIstrazivac.getEmail(), noviIstrazivac.getSifra());
            if (noviIstrazivac.getEmail() != null) {
                istrazivac.setEmail(noviIstrazivac.getEmail());
            }
            istrazivacDao.startSession();
            istrazivacDao.dodajIstrazivaca(istrazivac);
            istrazivacDao.stopSession();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<IstrazivacModel> listaIstrazivaca() {

        List<IstrazivacModel> istrazivaciModel = new ArrayList<>();

        istrazivacDao.startSession();
        List<Istrazivac> istrazivaci = istrazivacDao.listaIstrazivaca();
        istrazivacDao.stopSession();
        for (Istrazivac istrazivac : istrazivaci) {
            istrazivaciModel.add(new IstrazivacModel(istrazivac.getId(), istrazivac.getImePrezime(),
                    istrazivac.getIstrazivackaGrupa(), istrazivac.getEmail(), istrazivac.getSifra()));
        }

        return istrazivaciModel;
    }

    @Override
    public IstrazivacModel pronadjiIstrazivaca(int id) {

        istrazivacDao.startSession();
        Istrazivac istrazivac = istrazivacDao.pronadjiIstrazivaca(id);

        IstrazivacModel istrazivacModel = new IstrazivacModel(istrazivac.getId(), istrazivac.getImePrezime(),
                istrazivac.getIstrazivackaGrupa(), istrazivac.getEmail(), istrazivac.getSifra());
        istrazivacDao.stopSession();
        return istrazivacModel;
    }

    @Override
    public void promeniIstrazivaca(IstrazivacModel promenjenIstrazivac) {
        istrazivacDao.startSession();
        Istrazivac istrazivac = istrazivacDao.pronadjiIstrazivaca(promenjenIstrazivac.getId());
        istrazivac.setImePrezime(promenjenIstrazivac.getImePrezime());
        istrazivac.setIstrazivackaGrupa(promenjenIstrazivac.getIstrazivackaGrupa());
        istrazivac.setEmail(promenjenIstrazivac.getEmail());
        istrazivac.setSifra(promenjenIstrazivac.getSifra());

        if (promenjenIstrazivac.getEmail() != null) {
            istrazivac.setEmail(promenjenIstrazivac.getEmail());
        }
        istrazivacDao.promeniIstrazivaca(istrazivac);
        istrazivacDao.stopSession();
    }

    @Override
    public void obrisiIstrazivaca(IstrazivacModel obrisanIstrazivac) {
        istrazivacDao.startSession();
        Istrazivac Istrazivac = istrazivacDao.pronadjiIstrazivaca(obrisanIstrazivac.getId());
        istrazivacDao.obrisiIstrazivaca(Istrazivac);
        istrazivacDao.stopSession();
    }

}
