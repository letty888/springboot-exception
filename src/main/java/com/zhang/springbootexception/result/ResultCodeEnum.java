package com.zhang.springbootexception.result;


import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/10/12:06
 * @Description: 返回结果枚举类
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true,200,"操作成功!"),
    SYSTEM_ERROR(false,500,"系统正在打盹,请稍后重试!"),
    PARAM_ERROR(false,40001,"参数错误"),

    NO_AUTHORIZATION(false,40003,"您还未登录!");

    /**
     * 响应是否成功
     */
    private Boolean flag;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    ResultCodeEnum(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultCodeEnum{" +
                "flag=" + flag +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
