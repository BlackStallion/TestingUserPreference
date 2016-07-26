package com.unit.test;

/**
 * Created by maidulislam on 28/06/16.
 */
public interface LoginView {
    String getUsername();

    void showUsernameError(int resId);

    String getPassword();

    void showPasswordError(int resId);

    void startMainActivity();

    void showLoginError(int resId);

    void showLogInSuc(int resId);


}

