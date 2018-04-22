package ru.eidos.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DepartmentBadRequestExeption extends RuntimeException{
    public DepartmentBadRequestExeption() {
    }

    public DepartmentBadRequestExeption(String message) {
        super(message);
    }

    public DepartmentBadRequestExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentBadRequestExeption(Throwable cause) {
        super(cause);
    }

    public DepartmentBadRequestExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
