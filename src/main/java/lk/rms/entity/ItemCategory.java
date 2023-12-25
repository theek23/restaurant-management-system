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
@Table (name = "item_category")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ItemCategory implements SuperEntity{
    @Id
    @Column(name = "category_id")
    private String cateID;
    @Column(name = "category_name")
    private String cateName;
}
