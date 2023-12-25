package lk.rms.bo.custome;

import lk.rms.bo.SuperBO;
import lk.rms.dto.ItemCategoryDTO;
import lombok.SneakyThrows;

import java.util.ArrayList;

public interface ItemCategoryBO extends SuperBO {

    @SneakyThrows
    ArrayList<ItemCategoryDTO> getAllItemCategories();
}
