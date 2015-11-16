package com.springapp.command;

import java.io.Serializable;

/**
 * Created by Cuong on 2015/11/16.
 */
public class LoginCommand implements Serializable {

    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
