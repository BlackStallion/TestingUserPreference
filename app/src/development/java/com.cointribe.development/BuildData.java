package com.cointribe.development;

import com.com.cointribe.utils.Log;
import com.com.cointribe.utils.UtilityConstant;

import java.util.HashMap;

/**
 * Created by maidulislam on 05/07/16.
 */
public class BuildData {
    public static String noOfActivityTesting(String logIn) {
        HashMap<String,String> noOfActivityTesting = UtilityConstant.NoOfActivityForDevelopment();
        String temp=noOfActivityTesting.get(logIn);
        Log.d("BuildData","BuildData "+temp );
        return temp;
    }
}
