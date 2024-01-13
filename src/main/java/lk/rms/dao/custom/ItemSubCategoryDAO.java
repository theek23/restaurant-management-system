package lk.rms.dao.custom;

import lk.rms.dao.CrudDAO;
import lk.rms.entity.ItemSubCategory;

import java.util.ArrayList;

public interface ItemSubCategoryDAO extends CrudDAO<ItemSubCategory, String> {
    public ArrayList<ItemSubCategory> getAllAsItems(String catId);
}
