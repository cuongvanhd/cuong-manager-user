package com.springapp.command;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Cuong on 2015/11/20.
 */
public class UserInforCommand implements Serializable {

    private int userId;
    private String groupName;
    private String fullName;
    private String fullNameKata;
    private String email;
    private String tel;
    private Date birthday;
    private String nameLevel;
    private Date startDate;
    private Date endDate;
    private int total;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullNameKata() {
        return fullNameKata;
    }

    public void setFullNameKata(String fullNameKata) {
        this.fullNameKata = fullNameKata;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endtDate) {
        this.endDate = endtDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
