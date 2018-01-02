package cn.lemon.mvp.biz;


public interface IUserBiz {
    void login(String username, String password, OnLoginListener loginListener);
}
