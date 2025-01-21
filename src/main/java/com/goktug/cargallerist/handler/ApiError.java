package com.goktug.cargallerist.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError<T> {

    private Integer status;

    private Exception<T> exception;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Exception<T> getException() {
        return exception;
    }

    public void setException(Exception<T> exception) {
        this.exception = exception;
    }
}
