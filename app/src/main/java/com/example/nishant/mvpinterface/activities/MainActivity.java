package com.example.nishant.mvpinterface.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nishant.mvpinterface.R;
import com.example.nishant.mvpinterface.model.PresenterImplementation;
import com.example.nishant.mvpinterface.presenter.LoginPresenter;
import com.example.nishant.mvpinterface.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new PresenterImplementation(MainActivity.this);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.performLogin(((EditText)findViewById(R.id.username)).getText().toString(),
                        ((EditText)findViewById(R.id.password)).getText().toString());
            }
        });
    }

    @Override
    public void loginValidation() {
        Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Login Failure", Toast.LENGTH_SHORT).show();
    }
}
