package com.c20.admin.exception;

import com.c20.admin.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //自定义异常处理
    @ExceptionHandler(C20AdminException.class)
    @ResponseBody
    public Result error(C20AdminException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }
}
