package lk.rms.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "supplier")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Supplier implements SuperEntity {
    @Id
    @Column(name ="sup_id")
    private String supId;
    @Column(name ="sup_type")
    private String supType;
    @Column(name ="name")
    private String name;
    @Column(name ="phone")
    private String phone;
    @Column(name ="address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<QtyDetails> qtyDetails = new ArrayList<>();



    public Supplier(String supId, String supType, String name, String phone, String address) {
        this.supId = supId;
        this.supType = supType;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
