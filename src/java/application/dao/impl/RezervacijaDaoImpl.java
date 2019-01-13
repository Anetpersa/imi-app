package application.dao.impl;

import application.dao.RezervacijaDao;
import application.domains.Rezervacija;
import application.domains.Uredjaj;
import application.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RezervacijaDaoImpl implements RezervacijaDao {

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
    public boolean dodajRezervaciju(Rezervacija rezervacija) {
        Transaction ts = null;

        try {
            ts = session.beginTransaction();
            session.save(rezervacija);
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
    public List<Rezervacija> listaRezervacija() {
        Transaction ts = null;
        List<Rezervacija> rezervacije = new ArrayList<>();
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM Uredjaj");
            for (Object o : query.list()) {
                rezervacije.add((Rezervacija) o);
            }
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {
        }
        return rezervacije;
    }

    @Override
    public Rezervacija pronadjiRezervaciju(int id) {
        Transaction ts = null;
        Rezervacija rezervacija = null;
        try {
            ts = session.beginTransaction();
            rezervacija = (Rezervacija) session.load(Rezervacija.class, id);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }
        return rezervacija;
    }

    @Override
    public void promeniRezervaciju(Rezervacija rezervacija) {
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.update(rezervacija);
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
    public void obrisiRezervaciju(Rezervacija rezervacija) {
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.delete(rezervacija);
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
