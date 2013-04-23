package net.diegozhu.j2ee.ptms.utils;

public class StatusMessage {

    public static final int SUCCESS_CODE = 1;

    public static final int REGISTER_ERROR_CODE = 2;
    public static final String REGISTER_ERROR_MSG = "invalid email or password";

    public static final int LOGIN_ERROR_CODE = 3;
    public static final String LOGIN_ERROR_MSG = "invalid username or password";

    public static final int BINDPHONE_ERROR_CODE = 4;
    public static final String BINDPHONE_ERROR_MSG = "phone not correct";

    public static final String USER_ERROR_MSG = "user not exsit";

    public static final String USER_INFO_ERROR_MSG = "could not find userInfo";

    public static final int PASSWORD_ERROR_CODE = 5;
    public static final String PASSWORD_ERROR_MSG = "The oldPassword is not correct or the newPassword is not the same with the repassword!";

}
