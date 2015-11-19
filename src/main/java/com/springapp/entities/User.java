package com.springapp.entities;

import com.springapp.utils.ValidateProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Cuong on 2015/11/13.
 */
@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group mainGroup;

    @Column(name = "login_name")
    @NotBlank(message = ValidateProperties.LOGIN_NAME_NULL)
    private String loginName;

    @Column(name = "password")
    @NotBlank(message = ValidateProperties.PASSWORD_NULL)
    private String password;

    @Column(name = "full_name")
    @NotBlank(message = ValidateProperties.FULL_NAME_NULL)
    private String fullName;

    @Column(name = "full_name_kata")
    @NotBlank(message = ValidateProperties.FULL_NAME_KANA_NULL)
    @Pattern(regexp = ValidateProperties.FULL_NAME_KANA_PATTERN, message = ValidateProperties.FULL_NAME_BYTE)
    private String fullNameKata;

    @Column(name = "email")
    @NotBlank(message = ValidateProperties.EMAIL_NULL)
    @Pattern(regexp = ValidateProperties.EMAIL_PATTERN, message = ValidateProperties.EMAIL_ERROR)
    private String email;

    @Column(name = "tel")
    @NotBlank(message = ValidateProperties.TEL_NULL)
    @Pattern(regexp = ValidateProperties.TEL_PATTERN, message = ValidateProperties.TEL_ERROR)
    private String tel;

    @Column(name = "birthday")
    @NotBlank(message = ValidateProperties.BIRTHDAY_NULL)
    @Pattern(message = ValidateProperties.BIRTHDAY_ERROR, regexp = ValidateProperties.BIRTHDAY_PATTERN)
    private Date birthday;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private UserDetailJapanese userDetailJapanese;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Group getMainGroup() {
        return mainGroup;
    }

    public void setMainGroup(Group mainGroup) {
        this.mainGroup = mainGroup;
    }

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

//    public UserDetailJapanese getUserDetailJapanese() {
//        return userDetailJapanese;
//    }
//
//    public void setUserDetailJapanese(UserDetailJapanese userDetailJapanese) {
//        this.userDetailJapanese = userDetailJapanese;
//    }
}
