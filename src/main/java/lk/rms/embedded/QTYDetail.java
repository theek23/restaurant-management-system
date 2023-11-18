package lk.rms.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class QTYDetail {
    @Column(name = "item_id")
    private String itemID;
    @Column(name ="sup_id")
    private String supId;
}
