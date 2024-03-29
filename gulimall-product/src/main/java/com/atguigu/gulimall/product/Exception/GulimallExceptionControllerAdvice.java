package com.atguigu.gulimall.product.Exception;


import com.atguigu.common.exception.BizCodeEnume;
import com.atguigu.common.utils.R;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
//@ResponseBody
//@ControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e) {
        log.error("数据效验出现问题{},异常类型:{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();

        Map<String,String> errorMap = Maps.newHashMap();
        bindingResult.getFieldErrors().forEach(fieldError -> errorMap.put(fieldError.getField(),fieldError.getDefaultMessage()));
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(), BizCodeEnume.VAILD_EXCEPTION.getMessage()).put("data",errorMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),BizCodeEnume.UNKNOW_EXCEPTION.getMessage());
    }
}
