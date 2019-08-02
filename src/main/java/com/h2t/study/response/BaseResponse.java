package com.h2t.study.response;

/**
 * 统一返回结果
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/08/01 16:45
 */
public class BaseResponse<T> {
    /**
     * 返回的data
     * */
    private T data;

    /**
     * 错误码
     * */
    private String errorCode;

    /**
     * 错误信息
     * */
    private String errorMsg;

    /**
     * 是否成功
     * */
    private boolean success;
}
