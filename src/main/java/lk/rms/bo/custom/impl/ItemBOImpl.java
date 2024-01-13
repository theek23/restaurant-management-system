package lk.rms.bo.custom.impl;

import lk.rms.bo.custom.ItemBO;
import lk.rms.dao.DAOFactory;
import lk.rms.dao.custom.ItemDAO;
import lk.rms.dto.ItemDTO;
import lk.rms.entity.Item;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item entity : itemDAO.getAll()) {
            allItems.add(new ItemDTO(
                    entity.getItemID(),
                    entity.getCategory(),
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
                    entity.getCategory(),
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
                itemDTO.getCategory(),
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
                itemDTO.getCategory(),
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
}
