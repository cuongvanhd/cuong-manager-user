package com.springapp.utils;

/**
 * Created by Cuong on 15/11/2015.
 */
public class ValidateProperties {

    // Login
    public static final String LOGIN_NAME_NULL = "Please input login name!";
    public static final String LOGIN_ERROR = "LoginName or Password invalid, Please again!";

    // Password
    public static final String PASSWORD_NULL = "Please input password!";

    // Email
    public static final String EMAIL_NULL = "Please provide email! (ex: cuong123@gmail.com)";
    public static final String EMAIL_ERROR = "Email invalid, Please again!";
    public static final String EMAIL_PATTERN = "^(.+)@(.+)$";

    // FullName
    public static final String FULL_NAME_NULL = "Please input full name!";

    // FullNameKana
    public static final String FULL_NAME_KANA_NULL = "Please input full name kana!";
    public static final String FULL_NAME_BYTE = "Full name kana has to 2 bit character. (ex: ????????)";

    // Telephone
    public static final String TEL_NULL = "Please provide telephone number! (ex: 090 4564 4534)";
    public static final String TEL_ERROR = "Telephone number have to  digits!";
    public static final String TEL_PATTERN = "^\\\\+?[0-9. ()-]{10,25}$";

    // Birthday
    public static final String BIRTHDAY_NULL = "Please provide birthday!";
    public static final String BIRTHDAY_PATTERN = " YYYY/MM/dd";
    public static final String BIRTHDAY_ERROR = "Birthday invalid, please again!(ex: 1992/01/17)";


}
