package com.example.mybatis.handler;

import com.example.mybatis.exception.TargetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TargetNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleTargetNotFoundException(TargetNotFoundException targetNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(targetNotFoundException.getMessage());
    }

}
