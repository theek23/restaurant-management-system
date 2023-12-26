package lk.rms.dto;

import lk.rms.entity.ItemCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemDTO {
    private String itemID;
    private ItemCategory category;
    private String subCategory;
    private String description;
    private Double sellingPrice;
    private Integer qtyOnHand;
}
