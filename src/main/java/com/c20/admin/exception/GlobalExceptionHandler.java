package com.c20.admin.exception;

import com.c20.admin.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 自定义异常处理类
@ControllerAdvice
public class GlobalExceptionHandler {


    //自定义异常处理
    @ExceptionHandler(AdminException.class)
    @ResponseBody
    public Result error(AdminException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }

}
