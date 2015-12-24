package edu.vaspoz.spittr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Vasilii_Pozdeev on 24-Dec-15.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle not found")
public class SpittleNotFountException extends RuntimeException {
}
