package lk.rms.controller.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierTM {
    private String supId;
    private String supType;
    private String name;
    private String phone;
    private String address;
}
