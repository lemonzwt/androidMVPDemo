package cn.lemon.mvp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.lemon.mvp.presenter.UserLoginPresenter;
import cn.lemon.mvp.view.IUserLoginView;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {
    EditText dtLoginName, dtPassword;
    Button btnLogin;
    UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    public String getLoginName() {
        return dtLoginName.getText().toString();
    }

    @Override
    public String getPassword() {
        return dtPassword.getText().toString();
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "失败", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dtLoginName = (EditText) findViewById(R.id.loginName);
        dtPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });
    }
}
