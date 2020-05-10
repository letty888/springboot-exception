package com.zhang.springbootexception.exception.handler;

import com.zhang.springbootexception.exception.CommonException;
import com.zhang.springbootexception.result.Result;
import com.zhang.springbootexception.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/10/12:30
 * @Description:
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exception(HttpServletRequest request, HttpServletResponse response, Exception e) {
        //注意:这里一定要打印异常,不然后台报错后不知道是哪里出现了问题
        e.printStackTrace();
        //这里的目的是将异常信息添加到日志的文件中
        log.error(Arrays.toString(e.getStackTrace()));
        //1.如果捕获到了自定义异常
        if (e instanceof CommonException) {

            CommonException commonException = (CommonException) e;

            return new Result(commonException.getResultCode());
        }

        //后期可以继续 if...else...来捕获别的异常(比如没有权限等)...
        return new Result(ResultCodeEnum.SYSTEM_ERROR);
    }
}
