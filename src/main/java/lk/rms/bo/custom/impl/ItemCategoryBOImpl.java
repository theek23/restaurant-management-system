package lk.rms.bo.custom.impl;

import lk.rms.bo.custom.ItemCategoryBO;
import lk.rms.dao.DAOFactory;
import lk.rms.dao.custom.ItemCategoryDAO;
import lk.rms.dto.ItemCategoryDTO;
import lk.rms.entity.ItemCategory;

import java.util.ArrayList;

public class ItemCategoryBOImpl implements ItemCategoryBO {
    private final ItemCategoryDAO itemCategoryDAO = (ItemCategoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEMCATEGORY);

    @Override
    public ArrayList<ItemCategoryDTO> getAllItemCategories() {
        ArrayList<ItemCategoryDTO> allItemCategories = new ArrayList<>();
        for (ItemCategory entity : itemCategoryDAO.getAll()) {
            allItemCategories.add(new ItemCategoryDTO(
                    entity.getCateID(),
                    entity.getCateName()
            ));
        }
        return allItemCategories;
    }

    public ArrayList<String> getAllCategoryNames() {
        ArrayList<String> allItemCategoryNames = new ArrayList<>();
        for (ItemCategory entity : itemCategoryDAO.getAll()) {
            allItemCategoryNames.add(entity.getCateID()+"-"+entity.getCateName());
        }
        return allItemCategoryNames;
    }
}
