package lk.rms.bo.custom;

import lk.rms.bo.SuperBO;
import lk.rms.dto.ItemCategoryDTO;
import lombok.SneakyThrows;

import java.util.ArrayList;

public interface ItemCategoryBO extends SuperBO {

    @SneakyThrows
    ArrayList<ItemCategoryDTO> getAllItemCategories();

    ArrayList<String> getAllCategoryNames();
}
