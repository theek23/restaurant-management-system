package lk.rms.bo.custom;

import lk.rms.bo.SuperBO;

import java.util.ArrayList;

public interface ItemSubCategoryBO extends SuperBO {
    ArrayList<String> getAllCategoryNames();
    ArrayList<String> getAllSubCategoryNamesAsCategory(String catID);
}
