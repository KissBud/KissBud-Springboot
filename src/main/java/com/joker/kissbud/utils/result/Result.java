package com.joker.kissbud.utils.result;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回封装类型
 * @author LanJian
 */
public class Result<T> {

    /**
     * 附加信息
     */
    @Getter
    @Setter
    private String message;

    /**
     * 返回结果类型
     */
    @Setter
    @Getter
    private ResultType resultType;

    /**
     * 执行结果
     */
    @Getter
    @Setter
    private T data;

    private Result(T data){
        this(data, ResultType.BUSINESS_SUCCESS, "操作完成!");
    }

    private Result(ResultType type){
        this(null, type, "");
    }

    private Result(T data, ResultType type, String message){
        this.data = data;
        this.resultType = type;
        this.message = message;
    }

    private static <T> Result build(T data){
        return new Result<>(data);
    }

    private static <T> Result build(T data, ResultType type){
        return new Result<T>(data, type, "");
    }

    private static Result build(ResultType type){
        return new Result(type);
    }

    public static <T> Result body(T data, ResultType type){
        return build(data, type);
    }

    public static <T> Result ok(T data){
        return build(data);
    }

    public Result withMessage(String message){
        this.message = message;
        return this;
    }

    public Result(){

    }
}