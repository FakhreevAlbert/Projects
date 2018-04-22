package ru.eidos.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ManagerBadRequestExeption extends RuntimeException {
    public ManagerBadRequestExeption() {
    }

    public ManagerBadRequestExeption(String message) {
        super(message);
    }

    public ManagerBadRequestExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerBadRequestExeption(Throwable cause) {
        super(cause);
    }

    public ManagerBadRequestExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
