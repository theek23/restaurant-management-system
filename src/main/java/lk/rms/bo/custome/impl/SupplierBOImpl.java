package lk.rms.bo.custome.impl;

import lk.rms.bo.custome.SupplierBO;
import lk.rms.dao.DAOFactory;
import lk.rms.dao.custom.SupplierDAO;
import lk.rms.dto.SupplierDTO;
import lk.rms.entity.Supplier;

import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {
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

    @Override
    public String generateNewId() {
        String lastID = supplierDAO.generateNewID();

        if (lastID == null) {
            return "SUP00-0001";
        } else {
            int lastNumber = Integer.parseInt(lastID.substring(7));

            int newNumber = lastNumber+1;

            String newId = String.format("SUP00-%04d", newNumber);

            return newId;
        }
    }

    @Override
    public ArrayList<SupplierDTO> searchByName(String enteredName) {

        ArrayList<SupplierDTO> allSuppliers = getAllSupplier();
        ArrayList<SupplierDTO> resultSuppliers = new ArrayList<>();

        for (SupplierDTO supplier : allSuppliers) {
            String supplierName = supplier.getName();

            if (supplierName.compareTo(enteredName) > 0) {
                resultSuppliers.add(supplier);
            }
        }

        return resultSuppliers;
    }
}
