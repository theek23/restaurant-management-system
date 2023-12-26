package lk.rms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item_sub_category")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ItemSubCategory implements SuperEntity {
    @Id
    @Column(name = "cat_id")
    private String subCatID;

    @Column(name = "name")
    private String subCatName;

    @ManyToOne
    @JoinColumn(name = "category_id") // This is the foreign key column in the item_sub_category table
    private ItemCategory category;
}
