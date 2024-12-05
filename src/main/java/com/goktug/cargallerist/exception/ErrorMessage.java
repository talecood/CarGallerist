package com.goktug.cargallerist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private String ofStatic;

    private MessageType messageType;

    public String prepareErrorMessage(){
        StringBuilder sb = new StringBuilder();

        sb.append(messageType.getMessage());
        if(this.ofStatic!=null) {
            sb.append(": "+ofStatic);
        }
        return sb.toString();
    }

}
