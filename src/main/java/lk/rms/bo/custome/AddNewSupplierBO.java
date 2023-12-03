package lk.rms.bo.custome;

import lk.rms.bo.SuperBO;
import lk.rms.dto.SupplierDTO;
import lk.rms.dto.SupplierDTO;
import lombok.SneakyThrows;

import java.util.ArrayList;

public interface AddNewSupplierBO extends SuperBO {
    @SneakyThrows
    ArrayList<SupplierDTO> getAllSupplier();

    @SneakyThrows
    SupplierDTO searchSupplier(String supID);

    @SneakyThrows
    boolean supplierIsExsist(String supID);

    @SneakyThrows
    boolean saveSupplier(SupplierDTO supplierDTO);

    @SneakyThrows
    boolean updateSupplier(SupplierDTO supplierDTO);

    @SneakyThrows
    boolean deleteSupplier(String supID);
}
