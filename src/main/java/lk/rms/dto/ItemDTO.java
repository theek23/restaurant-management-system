package lk.rms.dto;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import lk.rms.entity.ItemCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemDTO extends RecursiveTreeObject<ItemDTO> {
    private String itemID;
    private ItemCategoryDTO category;
    private String subCategory;
    private String description;
    private Double sellingPrice;
    private Integer qtyOnHand;
}
