package ru.eidos.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ManagerNotFounException extends RuntimeException {

    public ManagerNotFounException() {
    }

    public ManagerNotFounException(String message) {
        super(message);
    }

    public ManagerNotFounException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerNotFounException(Throwable cause) {
        super(cause);
    }

    public ManagerNotFounException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
