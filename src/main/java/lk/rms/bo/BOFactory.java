package lk.rms.bo;

import lk.rms.bo.custom.impl.ItemBOImpl;
import lk.rms.bo.custom.impl.ItemCategoryBOImpl;
import lk.rms.bo.custom.impl.ItemSubCategoryBOImpl;
import lk.rms.bo.custom.impl.SupplierBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){
    }
    public static BOFactory getBoFactory(){return boFactory == null ? boFactory = new BOFactory() : boFactory;}

    public enum BOTypes{
        ITEM , SUPPLIER, ITEMCATEGORY, ITEMSUBCATEGORY
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case ITEM:
                return new ItemBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case ITEMCATEGORY:
                return new ItemCategoryBOImpl();
            case ITEMSUBCATEGORY:
                return new ItemSubCategoryBOImpl();
            default:
                return null;
        }
    }
}

