package edu.vaspoz.spittr.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Vasilii_Pozdeev on 24-Dec-15.
 */
@ControllerAdvice
public class ErrorsHandler {
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle() {
        return "error/duplicate";
    }
}
