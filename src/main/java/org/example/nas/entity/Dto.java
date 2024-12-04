package org.example.nas.entity;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据传输对象
 **/
@Data
public class Dto<T> {

    /*用户信息*/
    public List<String> systemMsgList = new ArrayList<>();
    /*参数*/
    public List<Object> param;
    /*携带数据*/
    public T data;
    /*传递信息*/
    private String msg;
    /*是否成功*/
    private Boolean isSuccess;
    /*执行代码*/
    private String code;
    /*用户id*/
    private String userId;
    /*调用类*/
    private String className;
    /*调用方法*/
    private String methodName;
    /*是否有文件*/
    private Boolean isHaveFile;
    /*携带文件*/
    private String fileStr;

    /*成功方法*/
    @NotNull
    public static Dto<Object> success(String msg, Object data, String fileStr) {

        Dto<Object> dto = new Dto<>();

        dto.setMsg(msg);
        dto.setData(data);
        dto.setIsSuccess(true);
        dto.setCode("200");
        dto.setFileStr(fileStr);

        return dto;
    }

    /*成功方法*/
    @NotNull
    public static Dto<Object> success(String msg, Object data) {

        Dto<Object> dto = new Dto<>();

        dto.setMsg(msg);
        dto.setData(data);
        dto.setIsSuccess(true);
        dto.setCode("200");

        return dto;
    }

    /*成功方法重载*/
    @NotNull
    public static Dto<Object> success(String msg) {

        Dto<Object> dto = new Dto<>();

        dto.setMsg(msg);
        dto.setIsSuccess(true);
        dto.setCode("200");

        return dto;
    }

    /*失败方法*/
    @NotNull
    public static Dto<Object> fail(String msg, Object data, String code) {

        Dto<Object> dto = new Dto<>();

        dto.setMsg(msg);
        dto.setData(data);
        dto.setIsSuccess(false);
        dto.setCode(code);

        return dto;
    }

    /*失败方法重载*/
    @NotNull
    public static Dto<Object> fail(String msg, Object data) {

        Dto<Object> dto = new Dto<>();

        dto.setMsg(msg);
        dto.setData(data);
        dto.setIsSuccess(false);
        dto.setCode("-1");

        return dto;
    }

    /*失败方法重载*/
    @NotNull
    public static Dto<Object> fail(String msg) {

        Dto<Object> dto = new Dto<>();

        dto.setMsg(msg);
        dto.setData(null);
        dto.setIsSuccess(false);
        dto.setCode("-1");

        return dto;
    }

    /*失败方法重载*/
    @NotNull
    public static Dto<Object> fail(String msg, String code) {

        Dto<Object> dto = new Dto<>();

        dto.setMsg(msg);
        dto.setIsSuccess(false);
        dto.setCode(code);

        return dto;
    }

    /*请求数据方法*/
    @NotNull
    public static Dto<Object> query(String userId, String className, String methodName, List<Object> param) {

        Dto<Object> dto = new Dto<>();

        dto.setUserId(userId);
        dto.setClassName(className);
        dto.setMethodName(methodName);
        dto.setParam(param);

        return dto;
    }

    /*请求数据方法*/
    @NotNull
    public static Dto<Object> query(String className, String methodName, List<Object> param) {

        Dto<Object> dto = new Dto<>();

        dto.setUserId("-1");
        dto.setClassName(className);
        dto.setMethodName(methodName);
        dto.setParam(param);

        return dto;
    }
}
