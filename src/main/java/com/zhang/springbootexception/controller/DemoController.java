package com.zhang.springbootexception.controller;

import com.zhang.springbootexception.exception.CommonException;
import com.zhang.springbootexception.result.Result;
import com.zhang.springbootexception.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/10/12:04
 * @Description:
 */
@RestController
@RequestMapping("/demo")
@Slf4j//这个注解在正式开发环境中一般用在serviceimpl层
public class DemoController {

    @RequestMapping(value = "/noResponseData",method = RequestMethod.GET)
    public Result noResponseData() {
        return new Result(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping(value = "/haveResponseData",method = RequestMethod.GET)
    public Result haveResponseData() {
        return new Result(ResultCodeEnum.SUCCESS, "响应了正常的结果数据");
    }

    @RequestMapping(value = "/haveException",method = RequestMethod.GET)
    public Result haveException() {
        int i = 1 / 0;
        //执行到这里,会被全局异常捕获到异常
        return new Result(ResultCodeEnum.SUCCESS);
    }


    @RequestMapping(value = "/haveCommonException",method = RequestMethod.GET)
    public Result haveCommonException() {
        log.info("执行了haveCommonException方法...");
        //执行到这里,会被全局异常捕获到异常
        throw new CommonException(ResultCodeEnum.NO_AUTHORIZATION);
    }
}
