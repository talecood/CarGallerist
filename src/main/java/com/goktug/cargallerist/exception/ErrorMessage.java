package com.goktug.cargallerist.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ErrorMessage {

    private String ofStatic;

    private MessageType messageType;

    public ErrorMessage(String message, MessageType type) {
        this.ofStatic = message;
        this.messageType = type;
    }

    public ErrorMessage(String message, Long id) {

    }


    public String prepareErrorMessage(){
        StringBuilder sb = new StringBuilder();

        sb.append(messageType.getMessage());
        if(this.ofStatic!=null) {
            sb.append(": "+ofStatic);
        }
        return sb.toString();
    }

}
