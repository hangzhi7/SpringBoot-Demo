package com.hz.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应结构体
 *
 * @author hang.yuan
 * @date 2024/6/5 17:19
 */
@Data
public class Result implements Serializable {

    private Integer code;

    private Object data;

    private String msg;

    public static  Result success() {
        return success(null);
    }

    public static  Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        return result;
    }

    public static  Result failed() {
        return result(500,"未知异常，请联系管理员", null);
    }

    public static  Result failed(String msg) {
        return result(500, msg, null);
    }
    public static  Result failed(Integer code, String msg) {
        return result(code, msg, null);
    }

    public static  Result judge(boolean status) {
        if (status) {
            return success();
        } else {
            return failed();
        }
    }

    private static  Result result(Integer code, Object data) {
        return result(code,null, data);
    }

    private static  Result result(Integer code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
