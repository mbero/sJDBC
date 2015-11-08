package com.mbero.sjdbc.exceptions;

public class NotSettedFieldValueException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String message = "One of the fields in used object is not setted";
    
    public NotSettedFieldValueException() {
        super();
    }
 
    public NotSettedFieldValueException(String message) {
        super(message);
        this.message = message;
    }
 
    public NotSettedFieldValueException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}
