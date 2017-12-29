package com.example.nishant.mvpinterface.model;

import com.example.nishant.mvpinterface.presenter.LoginPresenter;
import com.example.nishant.mvpinterface.view.LoginView;

/**
 * Created by Nishant on 12/28/2017.
 */

public class PresenterImplementation implements LoginPresenter {

    LoginView loginView;

    public PresenterImplementation(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void performLogin(String username, String password) {
        if (username.trim().length()<1 || password.length()<1){
            loginView.loginValidation();
        }else {
            if (username.equals("admin") && password.equals("admin")){
                loginView.loginSuccess();
            }else {
                loginView.loginError();
            }
        }
    }
}
