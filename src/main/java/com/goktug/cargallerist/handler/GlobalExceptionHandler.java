package com.goktug.cargallerist.handler;

import com.goktug.cargallerist.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError<Object>> handleBaseException(Exception e, WebRequest req){
       return ResponseEntity.badRequest().body(createApiError(e.getMessage(),req));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValid(MethodArgumentNotValidException e, WebRequest req){
        Map<String, List<String>> map = new HashMap<>();
        for(ObjectError objectError : e.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError)objectError).getField();

            if(map.containsKey(fieldName)){
                map.put(fieldName,addValue(map.get(fieldName),objectError.getDefaultMessage()));
            }else{

                map.put(fieldName,addValue(new ArrayList<>(),objectError.getDefaultMessage()));
            }

        }

        return ResponseEntity.badRequest().body(createApiError(map,req));
    }

    private List<String> addValue(List<String> list,String newValue){
            list.add(newValue);
            return list;
    }

    public <T> ApiError<T> createApiError(T message, WebRequest request){
        ApiError<T> apiError = new ApiError<>();

    apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

    Exception<T> exception = new Exception<>();

    exception.setPath(request.getDescription(false).substring(4));
    exception.setCreateTime(new Date());
    exception.setMessage(message);
    exception.setHostName(getHostName());

    apiError.setException(exception);

    return apiError;

    }

    private String getHostName() {
        try{
        return Inet4Address.getLocalHost().getHostName();
    }catch (UnknownHostException e){
            e.printStackTrace();
        }
        return "";
    }
}
