package lk.rms.dao.custom.impl;

import lk.rms.dao.custom.ItemDAO;
import lk.rms.entity.Item;
import lk.rms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Item";
        Query query = session.createQuery(hql);
        List<Item> list = query.list();

        transaction.commit();
        session.close();
        Iterator<Item> iterator = list.iterator();
        ArrayList<Item> allItems = new ArrayList<>();
        while (iterator.hasNext()){
            allItems.add(iterator.next());
        }
        return allItems;
    }

    @Override
    public boolean save(Item entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String itemID) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Item item = session.load(Item.class, itemID);
        session.detach(item);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Item search(String itemID) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Item WHERE item_id =:iId";
        Query query = session.createQuery(hql);
        query.setParameter("iID", itemID);
        List<Item> list = query.list();

        transaction.commit();
        session.close();
        Iterator<Item> iterator = list.iterator();
        if (iterator.hasNext()){
            return iterator.next();
        }
        return null;
    }

    @Override
    public boolean isExists(String itemID) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT item_id FROM Item WHERE item_id=:iID";
        Query query = session.createQuery(hql);
        query.setParameter("iID", itemID);
        List<Item> list = query.list();
        Iterator<Item> iterator = list.iterator();

        transaction.commit();
        session.close();
        return iterator.hasNext();
    }

    @Override
    public String generateNewID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT i.itemID FROM Item i ORDER BY i.itemID DESC";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        String lastItemId = (String) query.uniqueResult();

        transaction.commit();
        session.close();

        return lastItemId;
    }
}
