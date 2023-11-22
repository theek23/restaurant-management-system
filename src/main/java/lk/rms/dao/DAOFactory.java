package lk.rms.dao;

import lk.rms.dao.custom.impl.ItemDAOImpl;
import lk.rms.dao.custom.impl.QTYDetailsDAOImpl;
import lk.rms.dao.custom.impl.SupplierDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory (){return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;}

    public enum DAOTypes{
        ITEM, SUPPLIER, QTYDETAILS
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case ITEM :
                return new ItemDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case QTYDETAILS:
                return new QTYDetailsDAOImpl();
            default:
                return null;
        }
    }
}
