package com.gdwii.permission.constants;

import com.gdwii.response.ErrorCode;

/**
 * 权限错误编码
 * 以1开头
 * 01为权限的用户
 * 02为权限角色
 */
public enum ErrorCodePermission implements ErrorCode{
    用户名已存在(1_01_01, "用户名已存在"),
    用户不存在(1_01_02, "用户名不存在"),

    权限不存在(1_02_01, "权限不存在")
    ;


    private ErrorCodePermission(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    @Override
    public int code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }
}
