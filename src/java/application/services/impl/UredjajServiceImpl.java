package application.services.impl;

import application.dao.UredjajDao;
import application.domains.Uredjaj;
import application.models.UredjajModel;
import application.services.UredjajService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UredjajServiceImpl implements UredjajService {

    @Autowired
    UredjajDao uredjajDao;

    public UredjajDao getUredjajDao() {
        return uredjajDao;
    }

    public void setIstrazivacDao(UredjajDao uredjajDao) {
        this.uredjajDao = uredjajDao;
    }

    @Override
    @Transactional
    public boolean dodajUredjaj(UredjajModel noviUredjaj) {

        if (noviUredjaj != null) {
            Uredjaj uredjaj = new Uredjaj(noviUredjaj.getNaziv(), noviUredjaj.getLab());
            if (noviUredjaj.getNaziv() != null) {
                uredjaj.setNaziv(noviUredjaj.getNaziv());
            }
            uredjajDao.startSession();
            uredjajDao.dodajUredjaj(uredjaj);
            uredjajDao.stopSession();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<UredjajModel> listaUredjaja() {

        List<UredjajModel> uredjajiModel = new ArrayList<>();

        uredjajDao.startSession();
        List<Uredjaj> uredjaji = uredjajDao.listaUredjaja();
        uredjajDao.stopSession();
        for (Uredjaj uredjaj : uredjaji) {
            uredjajiModel.add(new UredjajModel(uredjaj.getId(), uredjaj.getNaziv(), uredjaj.getLab()));
        }
        return uredjajiModel;
    }

    @Override
    public UredjajModel pronadjiUredjaj(int id) {
        
        uredjajDao.startSession();
        Uredjaj uredjaj = uredjajDao.pronadjiUredjaj(id);
        
        UredjajModel uredjajModel = new UredjajModel(uredjaj.getId(), uredjaj.getNaziv(), uredjaj.getLab());
        uredjajDao.stopSession();
        return uredjajModel;
    }

    @Override
    public void promeniUredjaj(UredjajModel promenjenUredjaj) {
        uredjajDao.startSession();
        Uredjaj uredjaj = uredjajDao.pronadjiUredjaj(promenjenUredjaj.getId());
        uredjaj.setNaziv(promenjenUredjaj.getNaziv());
        uredjaj.setLab(promenjenUredjaj.getLab());
                
        if (promenjenUredjaj.getNaziv() != null) {
            uredjaj.setNaziv(promenjenUredjaj.getNaziv());
        }
        uredjajDao.promeniUredjaj(uredjaj);
        uredjajDao.stopSession();
    }

    @Override
    public void obrisiUredjaj(UredjajModel obrisanUredjaj) {
        uredjajDao.startSession();
        Uredjaj uredjaj = uredjajDao.pronadjiUredjaj(obrisanUredjaj.getId());
        uredjajDao.obrisiUredjaj(uredjaj);
        uredjajDao.stopSession();
    }

}
