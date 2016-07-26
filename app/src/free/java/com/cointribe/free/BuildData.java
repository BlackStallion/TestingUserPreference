package com.cointribe.free;

import com.com.cointribe.utils.Log;
import com.com.cointribe.utils.UtilityConstant;

import java.util.HashMap;

/**
 * Created by maidulislam on 05/07/16.
 */
public class BuildData {
    public static String noOfActivityTesting(String logIn) {
        HashMap<String,String> noOfActivityTesting = UtilityConstant.NoOfActivityForTFree();
        String temp=noOfActivityTesting.get(logIn);
        Log.d("BuildData","BuildData "+temp );
        return temp;
    }
}
