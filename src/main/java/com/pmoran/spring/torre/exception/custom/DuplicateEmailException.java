package com.pmoran.spring.torre.exception.custom;

/**
 * @author Ankit Patel
 * @implNote Duplicate Email Exception
 */
public class DuplicateEmailException extends RuntimeException {

    private String errorMessage;

    public DuplicateEmailException(String errorMessage) {
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
