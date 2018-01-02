package cn.lemon.mvp.presenter;

import android.os.Handler;

import cn.lemon.mvp.bean.LoginInfo;
import cn.lemon.mvp.biz.IUserBiz;
import cn.lemon.mvp.biz.OnLoginListener;
import cn.lemon.mvp.biz.UserBiz;
import cn.lemon.mvp.view.IUserLoginView;


public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler handler = new Handler();
    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }
    public void login(){
        userBiz.login(userLoginView.getLoginName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(LoginInfo loginInfo) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showSuccess();
                    }
                });
            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                    }
                });

            }
        });
    }
}
