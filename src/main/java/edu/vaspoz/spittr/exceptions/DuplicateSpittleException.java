package edu.vaspoz.spittr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Vasilii_Pozdeev on 24-Dec-15.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "That Spittle is already exist")
public class DuplicateSpittleException extends RuntimeException {
}
