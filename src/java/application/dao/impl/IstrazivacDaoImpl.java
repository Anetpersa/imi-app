package application.dao.impl;

import application.dao.IstrazivacDao;
import application.domains.Istrazivac;
import application.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class IstrazivacDaoImpl implements IstrazivacDao {

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
    public boolean dodajIstrazivaca(Istrazivac Istrazivac) {

        Transaction ts = null;

        try {
            ts = session.beginTransaction();
            session.save(Istrazivac);
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
    public List<Istrazivac> listaIstrazivaca() {

        Transaction ts = null;
        List<Istrazivac> istrazivaci = new ArrayList<>();
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM Istrazivac");
            for (Object o : query.list()) {
                istrazivaci.add((Istrazivac) o);
            }
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {
        }
        return istrazivaci;
    }

    @Override
    public Istrazivac pronadjiIstrazivaca(int id) {
        Transaction ts = null;
        Istrazivac istrazivac = null;
        try {
            ts = session.beginTransaction();
            istrazivac = (Istrazivac) session.load(Istrazivac.class, id);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }
        return istrazivac;
    }

    @Override
    public void promeniIstrazivaca(Istrazivac istrazivac) {
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.update(istrazivac);
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
    public void obrisiIstrazivaca(Istrazivac istrazivac) {
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.delete(istrazivac);
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
