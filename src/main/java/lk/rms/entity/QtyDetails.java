package lk.rms.entity;

import lk.rms.embedded.QTYDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "qty_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class QtyDetails implements SuperEntity {
    @EmbeddedId
    private QTYDetail qtyDetail;
    @Column (name = "date_time" )
    private String dateTime;
    @Column (name = "cost" )
    private Double cost;
    @Column (name = "payment_status" )
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "item_id",
                referencedColumnName = "item_id",
                insertable = false,
                updatable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "sup_id",
            referencedColumnName = "sup_id",
            insertable = false,
            updatable = false)
    private Supplier supplier;
}
