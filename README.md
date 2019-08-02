# SpringBoot统一异常/统一结果处理

### 统一结果封装类
```
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
    private boolean success = false;

    /**
     * 出现异常的构造函数
     * */
    public BaseResponse(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * 成功返回的结果
     * */
    public BaseResponse(T data) {
        success = true;
        this.data = data;
    }

    public static <T>BaseResponse success(T data) {
        return new BaseResponse(data);
    }

    public static BaseResponse fail(String errorCode, String errorMsg) {
        return new BaseResponse(errorCode, errorMsg);
    }

    // getter and setter
    @Override
    public String toString() {
        return "BaseResponse{" +
                "data=" + data +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", success=" + success +
                '}';
    }
}

```
统一返回结果封装类包含了`data`，`errorMsg`，`errorCode`，`succeess`这几个返回结果所必须的参数
### 统一异常处理
```
@ControllerAdvice
@ResponseBody
public class ResponseHandler {
    private static Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    @ExceptionHandler({CustomException.class})
    public BaseResponse customException(CustomException e, HttpServletRequest request) {
        logger.error(request.getRequestURI() + ":服务运行异常",e);
        return BaseResponse.fail(e.getErrorCodeEnum().getErrorCode(), e.getErrorCodeEnum().getErrorMsg());
    }

    @ExceptionHandler({Exception.class})
    public BaseResponse otherResponse(Exception e, HttpServletRequest request) {
        logger.error(request.getRequestURI() + ":自定义异常",e);
        return BaseResponse.fail(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                e.getMessage());
    }
}
```
### 统一结果返回
```
@Aspect
@Component
public class ResponseAspect {
    @Around("execution(* com.h2t.study.controller..*(..))")
    public Object controllerProcess(ProceedingJoinPoint pjd) throws Throwable {
        Object result = pjd.proceed();
        //如果controller不返回结果
        if (result == null) {
            return BaseResponse.success(null);
        }

        return BaseResponse.success(result);
    }
}
```
### 测试



