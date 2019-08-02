package com.h2t.study.controller;

import com.h2t.study.enums.ErrorCodeEnum;
import com.h2t.study.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/08/01 16:26
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public Object helloWorld() {
        return "hello world";
    }

    @GetMapping("/test")
    public Object test() {
        throw new CustomException(ErrorCodeEnum.Param_does_not_correct);
    }

    @GetMapping("/test2")
    public Object test2() {
        System.out.println("enter");
        return 2 / 0;
    }
}
