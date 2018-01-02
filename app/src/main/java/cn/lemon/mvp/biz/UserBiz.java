package cn.lemon.mvp.biz;


import cn.lemon.mvp.bean.LoginInfo;


public class UserBiz implements IUserBiz {
    @Override
    public void login(final String loginName, final String password, final OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("123".equals(loginName) && "123".equals(password)) {
                    LoginInfo user = new LoginInfo();
                    user.setLoginName(loginName);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
