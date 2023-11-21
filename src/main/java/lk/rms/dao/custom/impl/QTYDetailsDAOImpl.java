package lk.rms.dao.custom.impl;

import lk.rms.dao.custom.QTYDetailsDAO;
import lk.rms.entity.QtyDetails;
import lk.rms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QTYDetailsDAOImpl implements QTYDetailsDAO {
    @Override
    public ArrayList<QtyDetails> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM QtyDetails";
        Query query = session.createQuery(hql);
        List<QtyDetails> list = query.list();

        transaction.commit();
        session.close();
        Iterator<QtyDetails> iterator = list.iterator();
        ArrayList<QtyDetails> allQtyDetails = new ArrayList<>();
        while (iterator.hasNext()){
            allQtyDetails.add(iterator.next());
        }
        return allQtyDetails;
    }

    @Override
    public boolean save(QtyDetails entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(QtyDetails entity) {
        return true;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public QtyDetails search(String s) {
        return null;
    }

    @Override
    public boolean isExists(String s) {
        return false;
    }

    @Override
    public String generateNewID() {
        return null;
    }
}
