package com.unit.test;

import com.com.cointribe.model.ApiResponseBoolean;
import com.com.cointribe.utils.Log;

import test.unit.cointribe.com.myapplication.LogIn;

/**
 * Created by maidulislam on 28/06/16.
 */
public class LoginService {
    ApiResponseBoolean apiResponseBoolean;
    LogIn logIn=new LogIn();
    public boolean login(String username, String password) {

        logIn.uerLogIn(username,password);
        Log.d("LoginService ","apiResponseBoolean");
        boolean bool=apiResponseBoolean.isResponse();

        return "9910510346".equals(username) && "1234".equals(password);
    }
}