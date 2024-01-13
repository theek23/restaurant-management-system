package lk.rms.bo.custom.impl;

import lk.rms.bo.custom.ItemBO;
import lk.rms.dao.DAOFactory;
import lk.rms.dao.custom.ItemDAO;
import lk.rms.dto.ItemCategoryDTO;
import lk.rms.dto.ItemDTO;
import lk.rms.entity.Item;
import lk.rms.entity.ItemCategory;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item entity : itemDAO.getAll()) {
            allItems.add(new ItemDTO(
                    entity.getItemID(),
                    new ItemCategoryDTO(
                            entity.getCategory().getCateID(),
                            entity.getCategory().getCateName()
                    ),
                    entity.getSubCategory(),
                    entity.getDescription(),
                    entity.getSellingPrice(),
                    entity.getQtyOnHand()
            ));
        }
        return allItems;
    }

    @Override
    public ItemDTO searchItem(String itemID) {
        Item entity = itemDAO.search(itemID);
        if (entity != null){
            return new ItemDTO(
                    entity.getItemID(),
                    new ItemCategoryDTO(
                            entity.getCategory().getCateID(),
                            entity.getCategory().getCateName()
                    ),
                    entity.getSubCategory(),
                    entity.getDescription(),
                    entity.getSellingPrice(),
                    entity.getQtyOnHand()
            );
        }
        return null;
    }

    @Override
    public boolean itemIsExsist(String itemID) {
        return itemDAO.isExists(itemID);
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) {
        return itemDAO.save(new Item(
                itemDTO.getItemID(),
                new ItemCategory(
                        itemDTO.getCategory().getCateID(),
                        itemDTO.getCategory().getCateName()
                ),
                itemDTO.getSubCategory(),
                itemDTO.getDescription(),
                itemDTO.getSellingPrice(),
                itemDTO.getQtyOnHand()
        ));
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) {
        return itemDAO.update(new Item(
                itemDTO.getItemID(),
                new ItemCategory(
                        itemDTO.getCategory().getCateID(),
                        itemDTO.getCategory().getCateName()
                ),
                itemDTO.getSubCategory(),
                itemDTO.getDescription(),
                itemDTO.getSellingPrice(),
                itemDTO.getQtyOnHand()
        ));
    }

    @Override
    public boolean deleteItem(String itemID) {
        return itemDAO.delete(itemID);
    }

    @Override
    public String generateNewId() {
        String lastID = itemDAO.generateNewID();

        if (lastID == null) {
            return "ITM00-0001";
        } else {
            int lastNumber = Integer.parseInt(lastID.substring(7));

            int newNumber = lastNumber+1;

            String newId = String.format("ITM00-%04d", newNumber);

            return newId;
        }
    }
}
