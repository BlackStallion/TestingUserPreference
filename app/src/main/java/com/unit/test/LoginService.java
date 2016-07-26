package com.unit.test;

import android.app.ProgressDialog;

import com.cointribe.networks.CommonNetworkClass;
import com.com.cointribe.model.ApiResponseBoolean;
import com.com.cointribe.utils.Constants;
import com.com.cointribe.utils.Log;
import com.com.cointribe.utils.TokenSavedData;

import org.json.JSONException;
import org.json.JSONObject;

import test.unit.cointribe.com.myapplication.LogIn;

/**
 * Created by maidulislam on 28/06/16.
 */
public class LoginService {
    ApiResponseBoolean apiResponseBoolean;
    private LogIn logIn;


    public LoginService(LogIn logIn) {
        this.logIn = logIn;
    }

    public boolean login(String username, String password) {
        return true;

    }

    public void loginIn(String username, String password) {
        ProgressDialog pDialog = new ProgressDialog(logIn);
        JSONObject params = new JSONObject();
        params = TokenSavedData.SetAccessTokenToJsonObject(logIn, params);
        JSONObject a = new JSONObject();

        try {
            a.put("mobile", username);
            a.put("pin", password);  //need to change
            params.put("data", a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("login params", params.toString());
        int flags = Constants.FLAG_SHOW_LOGS | Constants.FLAG_SHOW_LOADER;
        new CommonNetworkClass(logIn).NetworkHandlerResponseData(logIn,flags,pDialog,Constants.URL_LOGIN,Constants.ID_LOGIN,params);

    }


}