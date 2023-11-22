package lk.rms.bo;

import lk.rms.bo.custome.impl.AddNewItemBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){
    }
    public static BOFactory getBoFactory(){return boFactory == null ? boFactory = new BOFactory() : boFactory;}

    public enum BOTypes{
        ADDNEWITEM
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case ADDNEWITEM:
                return new AddNewItemBOImpl();
            default:
                return null;
        }
    }
}

