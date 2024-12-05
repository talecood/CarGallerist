package com.goktug.cargallerist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum MessageType
{
    GENERAL_EXCEPTION("9999","General error occured!"),
    NO_RECORD_EXIST("1004","record not found!");

    private String code;

    private String message;
}
