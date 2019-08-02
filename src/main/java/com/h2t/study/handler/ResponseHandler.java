package com.h2t.study.handler;

import com.h2t.study.exception.CustomException;
import com.h2t.study.response.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一返回结果异常处理类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/08/02 10:16
 */
@ControllerAdvice
@ResponseBody
public class ResponseHandler {
    @ExceptionHandler({CustomException.class})
    public BaseResponse customException(CustomException e) {
        return BaseResponse.fail(e.getErrorCodeEnum().getErrorCode(), e.getErrorCodeEnum().getErrorMsg());
    }
}
