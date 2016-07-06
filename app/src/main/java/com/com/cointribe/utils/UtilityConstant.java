package com.com.cointribe.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by maidulislam on 05/07/16.
 */
public class UtilityConstant {

    public static HashMap<String, String> NoOfActivityForDevelopment() {
        HashMap<String, String> noOfActivity = new LinkedHashMap<>();
        noOfActivity.put("LogIn", "DevelopmentUserInstructionPage"); //key,value
        noOfActivity.put("DevelopmentUserInstructionPage", "HomePage");
        noOfActivity.put("HomePage", "ProductPage");
        return noOfActivity;
    }

    public static HashMap<String, String> NoOfActivityForTFree() {
        HashMap<String, String> noOfActivity = new LinkedHashMap<>();
        noOfActivity.put("LogIn", "FreeUserInstructionPage"); //key,value
        noOfActivity.put("FreeUserInstructionPage", "HomePage");
        noOfActivity.put("HomePage", "ProductPage");
        return noOfActivity;
    }
    public static HashMap<String, String> NoOfActivityForGold() {
        HashMap<String, String> noOfActivity = new LinkedHashMap<>();
        noOfActivity.put("LogIn", "HomePageGold"); //key,value
        noOfActivity.put("HomePageGold", "ProductPage");
        return noOfActivity;
    }
}
