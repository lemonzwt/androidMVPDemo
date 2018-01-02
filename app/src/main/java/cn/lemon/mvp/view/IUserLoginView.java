package cn.lemon.mvp.view;

public interface IUserLoginView {
    String getLoginName();
    String getPassword();
    void showSuccess();
    void showFailedError();
}
