package lk.rms.bo.custom;

import lk.rms.bo.SuperBO;
import lk.rms.dto.ItemDTO;
import lombok.SneakyThrows;

import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    @SneakyThrows
    ArrayList<ItemDTO> getAllItems();

    @SneakyThrows
    ItemDTO searchItem(String itemID);

    @SneakyThrows
    boolean itemIsExsist(String itemID);

    @SneakyThrows
    boolean saveItem(ItemDTO itemDTO);

    @SneakyThrows
    boolean updateItem(ItemDTO itemDTO);

    @SneakyThrows
    boolean deleteItem(String itemID);

    @SneakyThrows
    String generateNewId();

    ArrayList<ItemDTO> getItemsByCategory(String catId);
}
