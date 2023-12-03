package lk.rms.dao.custom.impl;

import lk.rms.dao.custom.SupplierDAO;
import lk.rms.entity.Supplier;
import lk.rms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public ArrayList<Supplier> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Supplier";
        Query query = session.createQuery(hql);
        List<Supplier> list = query.list();

        transaction.commit();
        session.close();
        Iterator<Supplier> iterator = list.iterator();
        ArrayList<Supplier> allSuppliers = new ArrayList<>();
        while (iterator.hasNext()){
            allSuppliers.add(iterator.next());
        }
        return allSuppliers;
    }

    @Override
    public boolean save(Supplier entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Supplier entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String supplierId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Supplier supplier = session.load(Supplier.class, supplierId);
        session.detach(supplier);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Supplier search(String supplierId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Supplier WHERE supplier_id =:sid";
        Query query = session.createQuery(hql);
        query.setParameter("sID", supplierId);
        List<Supplier> list = query.list();

        transaction.commit();
        session.close();
        Iterator<Supplier> iterator = list.iterator();
        if (iterator.hasNext()){
            return iterator.next();
        }
        return null;
    }

    @Override
    public boolean isExists(String supplierId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT supplier_id FROM Supplier WHERE supplier_id=:sID";
        Query query = session.createQuery(hql);
        query.setParameter("sID", supplierId);
        List<Supplier> list = query.list();
        Iterator<Supplier> iterator = list.iterator();

        transaction.commit();
        session.close();
        return iterator.hasNext();
    }

    @Override
    public String generateNewID() {
        return null;
    }
}
