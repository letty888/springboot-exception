package com.zhang.springbootexception.exception;

import com.zhang.springbootexception.result.ResultCodeEnum;
import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/10/12:28
 * @Description: 自定义异常
 */
@Getter
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = -1306917846740039344L;

    private ResultCodeEnum resultCode;

    public CommonException(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "CommonException{" +
                "resultCode=" + resultCode +
                '}';
    }
}
