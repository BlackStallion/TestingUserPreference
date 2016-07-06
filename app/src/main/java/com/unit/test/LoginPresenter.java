package com.unit.test;

import test.unit.cointribe.com.myapplication.R;

/**
 * Created by maidulislam on 28/06/16.
 */
public class LoginPresenter {
    private LoginView view;
    private LoginService service;

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    boolean response=false;

    public LoginPresenter(LoginView view, LoginService service) {
        this.view = view;
        this.service = service;
    }

    public void onLoginClicked() {
        String username = view.getUsername();
        if (username.isEmpty()) {
            view.showUsernameError(R.string.username_error);
            return;
        }

        String password = view.getPassword();
        if (password.isEmpty()) {
            view.showPasswordError(R.string.password_error);
            return;
        }
        boolean loginSucceeded = service.login(username, password);
        if (loginSucceeded) {
            view.showLogInSuc(R.string.login_suc);
            view.startMainActivity();
            return;
        }
        view.showLoginError(R.string.login_failed);
    }
}
