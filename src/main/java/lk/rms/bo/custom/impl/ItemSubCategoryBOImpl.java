package lk.rms.bo.custom.impl;

import lk.rms.bo.custom.ItemSubCategoryBO;
import lk.rms.dao.DAOFactory;
import lk.rms.dao.custom.ItemSubCategoryDAO;
import lk.rms.entity.ItemCategory;
import lk.rms.entity.ItemSubCategory;

import java.util.ArrayList;

public class ItemSubCategoryBOImpl implements ItemSubCategoryBO {
    private final ItemSubCategoryDAO itemSbCategoryDAO = (ItemSubCategoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEMSUBCATEGORY);
    @Override
    public ArrayList<String> getAllCategoryNames() {
        ArrayList<String> allItemSubCategoryNames = new ArrayList<>();
        for (ItemSubCategory entity : itemSbCategoryDAO.getAll()) {
            allItemSubCategoryNames.add(entity.getSubCatName());
        }
        return allItemSubCategoryNames;
    }

    @Override
    public ArrayList<String> getAllSubCategoryNamesAsCategory(String catID) {
        ArrayList<String> allItemSubCategoryNames = new ArrayList<>();
        for (ItemSubCategory entity : itemSbCategoryDAO.getAllAsItems(catID)) {
            allItemSubCategoryNames.add(entity.getSubCatName());
        }
        return allItemSubCategoryNames;
    }
}
