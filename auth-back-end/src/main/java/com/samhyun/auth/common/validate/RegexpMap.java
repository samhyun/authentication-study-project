package com.samhyun.auth.common.validate;

public class RegexpMap {
    public static final String EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    public static final String NICKNAME = "^[a-zA-Z0-9가-힣]([._-](?![._-])|[a-zA-Z0-9가-힣]){1,18}[a-zA-Z0-9가-힣]$";
    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%]).{6,}$";
    public static final String NAME = "^[가-힣]{1,8}$|^[a-zA-Z]{2,30}$";
    public static final String MOBILE = "^\\(?([0-9]{3,4})\\)?[-.\\s]?([0-9]{3,4})[-.\\s]?([0-9]{4})$";
}
