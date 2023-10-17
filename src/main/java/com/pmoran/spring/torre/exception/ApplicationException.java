package com.pmoran.spring.torre.exception;

import com.pmoran.spring.torre.exception.custom.DuplicateEmailException;
import com.pmoran.spring.torre.exception.custom.EmployeeNotFoundException;
import com.pmoran.spring.torre.model.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author Ankit Patel
 * @implNote Handle All Exception through Whole APP
 */
@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorMessageDTO> handleDuplicateEmailException(DuplicateEmailException duplicateEmailException) {
        return new ResponseEntity<ErrorMessageDTO>(new ErrorMessageDTO(HttpStatus.CONFLICT.value(), duplicateEmailException.getErrorMessage(), new Date().toString()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException) {
        return new ResponseEntity<ErrorMessageDTO>(new ErrorMessageDTO(HttpStatus.BAD_REQUEST.value(), employeeNotFoundException.getErrorMessage(), new Date().toString()), HttpStatus.BAD_REQUEST);
    }
}
