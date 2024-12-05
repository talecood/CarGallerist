package com.goktug.cargallerist.handler;

import com.goktug.cargallerist.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public void handleBaseException(){
    }

    public <T> ApiError<T> createApiError(T message, WebRequest request){
        ApiError<T> apiError = new ApiError<>();

    apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

    Exception<T> exception = new Exception<>();

    exception.setPath(request.getDescription(false));
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
            return null;
        }
    }
}
