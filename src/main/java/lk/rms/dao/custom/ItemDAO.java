package lk.rms.dao.custom;

import lk.rms.dao.CrudDAO;
import lk.rms.entity.Item;

import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String> {
    ArrayList<Item> getItemsByCategory(String catId);
}
