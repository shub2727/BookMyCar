package com.CarRentalUser.Exception;

public class PassWordIncorrectException extends RuntimeException{


    String resourceName;
    String fieldName;
    String fieldValue;

    public PassWordIncorrectException(){
        super("PassWord and ConfirmPassword does not matches");
    }

//    public PassWordIncorrectException(String resourceName, String fieldName, String fieldValue) {
//        super((String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue)) );
//        this.resourceName = resourceName;
//        this.fieldName = fieldName;
//        this.fieldValue = fieldValue;
//    }



}
