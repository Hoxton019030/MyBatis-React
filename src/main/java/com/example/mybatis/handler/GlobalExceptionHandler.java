package com.example.mybatis.handler;

import com.example.mybatis.exception.TargetNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TargetNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleTargetNotFoundException(TargetNotFoundException targetNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(targetNotFoundException.getMessage());
    }
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        return new ResponseEntity(fieldErrors, HttpStatus.OK); // TODO: 2023/5/10  這邊需要再調整， fieldError應該要在更細部的把值抓出來
    }

}
