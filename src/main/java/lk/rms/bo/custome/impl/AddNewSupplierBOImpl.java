package lk.rms.bo.custome.impl;

import lk.rms.bo.custome.AddNewSupplierBO;
import lk.rms.dao.DAOFactory;
import lk.rms.dao.custom.SupplierDAO;
import lk.rms.dto.SupplierDTO;
import lk.rms.entity.Supplier;

import java.util.ArrayList;

public class AddNewSupplierBOImpl implements AddNewSupplierBO {
    private final SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public ArrayList<SupplierDTO> getAllSupplier() {
        ArrayList<SupplierDTO> allSuppliers = new ArrayList<>();
        for (Supplier entity : supplierDAO.getAll()) {
            allSuppliers.add(new SupplierDTO(
                    entity.getSupId(),
                    entity.getSupType(),
                    entity.getName(),
                    entity.getPhone(),
                    entity.getAddress()
            ));
        }
        return allSuppliers;
    }

    @Override
    public SupplierDTO searchSupplier(String supID) {
        Supplier entity = supplierDAO.search(supID);
        if (entity != null){
            return new SupplierDTO(
                    entity.getSupId(),
                    entity.getSupType(),
                    entity.getName(),
                    entity.getPhone(),
                    entity.getAddress()
            );
        }
        return null;
    }

    @Override
    public boolean supplierIsExsist(String supID) {
        return supplierDAO.isExists(supID);
    }

    @Override
    public boolean saveSupplier(SupplierDTO supplierDTO) {
        return supplierDAO.save(new Supplier(
                supplierDTO.getSupId(),
                supplierDTO.getSupType(),
                supplierDTO.getName(),
                supplierDTO.getAddress(),
                supplierDTO.getPhone()
        ));
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplierDTO) {
        return supplierDAO.update(new Supplier(
                supplierDTO.getSupId(),
                supplierDTO.getSupType(),
                supplierDTO.getName(),
                supplierDTO.getAddress(),
                supplierDTO.getPhone()
        ));
    }

    @Override
    public boolean deleteSupplier(String supID) {
        return supplierDAO.delete(supID);
    }
}
