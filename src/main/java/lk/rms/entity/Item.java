package lk.rms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "item")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Item implements SuperEntity{
    @Id
    @Column(name = "item_id")
    private String itemID;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private ItemCategory category;
    @Column(name = "sub_category")
    private String subCategory;
    @Column(name = "description")
    private String description;
    @Column(name = "selling_price")
    private Double sellingPrice;
    @Column(name = "qty_on_hand")
    private Integer qtyOnHand;

    public Item(String itemID, ItemCategory category, String subCategory, String description, Double sellingPrice, Integer qtyOnHand) {
        this.itemID = itemID;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.qtyOnHand = qtyOnHand;
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    private List<QtyDetails> qtyDetails = new ArrayList<>();
}
