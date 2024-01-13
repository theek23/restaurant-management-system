package lk.rms.dao.custom.impl;

import lk.rms.dao.custom.ItemSubCategoryDAO;
import lk.rms.entity.ItemSubCategory;
import lk.rms.entity.ItemSubCategory;
import lk.rms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemSubCategoryDAOImpl implements ItemSubCategoryDAO {
    @Override
    public ArrayList<ItemSubCategory> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItemSubCategory";
        Query query = session.createQuery(hql);
        List<ItemSubCategory> list = query.list();

        transaction.commit();
        session.close();
        Iterator<ItemSubCategory> iterator = list.iterator();
        ArrayList<ItemSubCategory> allItemSubCategories = new ArrayList<>();
        while (iterator.hasNext()){
            allItemSubCategories.add(iterator.next());
        }
        return allItemSubCategories;
    }

    @Override
    public boolean save(ItemSubCategory entity) {
        return false;
    }

    @Override
    public boolean update(ItemSubCategory entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public ItemSubCategory search(String s) {
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
    public ArrayList<ItemSubCategory> getAllAsItems(String catId){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM ItemSubCategory WHERE category.cateID = :catId";
        Query query = session.createQuery(hql);
        query.setParameter("catId", catId);
        List<ItemSubCategory> list = query.list();

        transaction.commit();
        session.close();
        Iterator<ItemSubCategory> iterator = list.iterator();
        ArrayList<ItemSubCategory> allItemSubCategories = new ArrayList<>();
        while (iterator.hasNext()){
            allItemSubCategories.add(iterator.next());
        }
        return allItemSubCategories;
    }
}
