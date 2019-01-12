package application.dao.impl;

import application.dao.UredjajDao;
import application.domains.Uredjaj;
import application.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UredjajDaoImpl implements UredjajDao {

    public Session session;

    @Override
    public void startSession() {
        session = HibernateUtil.createSessionFactory().openSession();
    }

    @Override
    public void stopSession() {
        session.close();
    }

    @Override
    public boolean dodajUredjaj(Uredjaj uredjaj) {

        Transaction ts = null;

        try {
            ts = session.beginTransaction();
            session.save(uredjaj);
            ts.commit();

        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {
            return true;
        }
    }

    @Override
    public List<Uredjaj> listaUredjaja() {

        Transaction ts = null;
        List<Uredjaj> uredjaji = new ArrayList<>();
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM Uredjaj");
            for (Object o : query.list()) {
                uredjaji.add((Uredjaj) o);
            }
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {
        }
        return uredjaji;
    }

    @Override
    public Uredjaj pronadjiUredjaj(int id) {
        Transaction ts = null;
        Uredjaj uredjaj = null;
        try {
            ts = session.beginTransaction();
            uredjaj = (Uredjaj) session.load(Uredjaj.class, id);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }
        return uredjaj;
    }

    @Override
    public void promeniUredjaj(Uredjaj uredjaj) {
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.update(uredjaj);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }
    }

    @Override
    public void obrisiUredjaj(Uredjaj uredjaj) {
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.delete(uredjaj);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }
    }
}
