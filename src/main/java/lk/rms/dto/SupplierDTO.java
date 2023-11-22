package lk.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SupplierDTO {
    private String supId;
    private String supType;
    private String name;
    private String phone;
    private String address;
}
