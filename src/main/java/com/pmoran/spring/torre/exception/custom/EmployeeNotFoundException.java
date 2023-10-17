package com.pmoran.spring.torre.exception.custom;

/**
 * @author Ankit Patel
 * @implNote Employee Not Present with ID  Exception
 */
public class EmployeeNotFoundException extends RuntimeException {

    private String errorMessage;

    public EmployeeNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
