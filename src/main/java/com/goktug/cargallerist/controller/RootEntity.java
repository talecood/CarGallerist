package com.goktug.cargallerist.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class RootEntity<T> {
    private Integer status;

    private T payload;

    private String errorMessage;


    public static <T> RootEntity<T> ok(T payload){
        RootEntity<T> rootEntity  =new RootEntity<>();
        rootEntity.setStatus(200);
        rootEntity.setPayload(payload);
        rootEntity.setErrorMessage(null);
        return rootEntity;
    }

    public static <T> RootEntity<T> error(String errorMessage){
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.setStatus(500);
        rootEntity.setPayload(null);
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
