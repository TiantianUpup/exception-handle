package com.h2t.study.enums;

/**
 * 错误代码枚举类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/08/01 16:51
 */
public enum ErrorCodeEnum {
    Param_does_not_exist("0001","查找参数不存在"),
    Param_does_not_correct("0002","所传参数格式不正确");

    ErrorCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    /**
     * 错误码
     * */
    private String errorCode;

    /**
     * 错误信息
     * */
    private String errorMsg;

    ssh -T git 969795191@qq.com@git 192.168.56.1

}
