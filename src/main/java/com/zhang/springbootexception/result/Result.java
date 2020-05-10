package com.zhang.springbootexception.result;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/10/12:09
 * @Description: 统一返回类
 */
@Data
public class Result {

    private Boolean flag;

    private Integer code;

    private String message;

    private Object data;

    public Result() {
    }

    public Result(Boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 设置结果，形参为结果枚举和要返回给前端的数据
     *
     * @param resultCodeEnum 返回结果枚举类
     * @param obj            需要传递到前端的数据
     */
    public Result(ResultCodeEnum resultCodeEnum, Object obj) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.flag = resultCodeEnum.getFlag();
        this.data = obj;
    }


    /**
     * 设置结果，形参为结果枚举
     *
     * @param resultCodeEnum 返回结果枚举类
     */
    public Result(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.flag = resultCodeEnum.getFlag();
    }

}
