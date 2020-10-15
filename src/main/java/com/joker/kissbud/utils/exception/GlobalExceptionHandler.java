package com.joker.kissbud.utils.exception;

import com.joker.kissbud.utils.result.Result;
import com.joker.kissbud.utils.result.ResultType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public Result globalException(HttpServletResponse response, NullPointerException ex){
        log.info("GlobalExceptionHandler...");
        log.info("错误代码："  + response.getStatus());
        Result result =  new Result();
        result.setResultType(ResultType.BUSINESS_ERROR);
        result.setMessage(ex.getMessage());
        return result;
    }
}