package lk.rms.dao.custom.impl;

import lk.rms.dao.custom.ItemCategoryDAO;
import lk.rms.entity.Item;
import lk.rms.entity.ItemCategory;
import lk.rms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemCategoryDAOImpl implements ItemCategoryDAO {
    @Override
    public ArrayList<ItemCategory> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItemCategory ";
        Query query = session.createQuery(hql);
        List<ItemCategory> list = query.list();

        transaction.commit();
        session.close();
        Iterator<ItemCategory> iterator = list.iterator();
        ArrayList<ItemCategory> allItemCategories = new ArrayList<>();
        while (iterator.hasNext()){
            allItemCategories.add(iterator.next());
        }
        return allItemCategories;
    }

    @Override
    public boolean save(ItemCategory entity) {
        return false;
    }

    @Override
    public boolean update(ItemCategory entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public ItemCategory search(String s) {
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
