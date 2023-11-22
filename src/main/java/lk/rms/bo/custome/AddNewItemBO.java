package lk.rms.bo.custome;

import lk.rms.bo.SuperBO;
import lk.rms.dto.ItemDTO;
import lombok.SneakyThrows;

import java.util.ArrayList;

public interface AddNewItemBO extends SuperBO {
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
}
