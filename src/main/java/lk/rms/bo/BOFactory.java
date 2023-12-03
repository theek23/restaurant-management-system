package lk.rms.bo;

import lk.rms.bo.custome.impl.AddNewItemBOImpl;
import lk.rms.bo.custome.impl.AddNewSupplierBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){
    }
    public static BOFactory getBoFactory(){return boFactory == null ? boFactory = new BOFactory() : boFactory;}

    public enum BOTypes{
        ADDNEWITEM , ADDNEWSUPPIER
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case ADDNEWITEM:
                return new AddNewItemBOImpl();

            case ADDNEWSUPPIER:
                return new AddNewSupplierBOImpl();
            default:
                return null;
        }
    }
}

