package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseStructure<Map<String, String>>> methodNotValid(
            MethodArgumentNotValidException exception) {
        ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<>();
        Map<String, String> map = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMsg = error.getDefaultMessage();
            map.put(fieldName, errorMsg);
        });
        responseStructure.setMessage("Please validate the proper data");
        responseStructure.setData(map);
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseStructure<String>> genuineException(Exception exception) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(exception.getMessage());
        responseStructure.setData(Arrays.toString(exception.getStackTrace()));
        
        return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
    }
}
