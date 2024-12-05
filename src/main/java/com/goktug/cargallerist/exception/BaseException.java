package com.goktug.cargallerist.exception;

public class BaseException extends RuntimeException{

   public BaseException(ErrorMessage errorMessage){
       super(errorMessage.prepareErrorMessage());
   }
}
