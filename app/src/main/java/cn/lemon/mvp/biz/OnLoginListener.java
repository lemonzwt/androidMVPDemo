package cn.lemon.mvp.biz;


import cn.lemon.mvp.bean.LoginInfo;


public interface OnLoginListener {
    void loginSuccess(LoginInfo loginInfo);

    void loginFailed();
}
