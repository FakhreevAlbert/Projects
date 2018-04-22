package ru.eidos.backend.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.eidos.backend.exception.DepartmentNotFoundException;
import ru.eidos.backend.exception.EmployeeNotFoundException;
import ru.eidos.backend.exception.ManagerBadRequestExeption;
import ru.eidos.backend.exception.ManagerNotFounException;
import ru.eidos.backend.response.RestErrorResponse;

@RestControllerAdvice(basePackages = "ru.eidos.backend.rest")
public class RestExeptionHandler {
    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> hangleManagerBadRequest(ManagerBadRequestExeption managerBadRequestExeption){
        HttpStatus status =HttpStatus.BAD_REQUEST;
        if (managerBadRequestExeption.getClass().isAnnotationPresent(ResponseStatus.class)){
            status =
                    managerBadRequestExeption.getClass().getAnnotation(
                    ResponseStatus.class
                    ).value();
        }
        RestErrorResponse response =new RestErrorResponse(status.value(), managerBadRequestExeption.getMessage());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> hangleManagerNotFound(ManagerNotFounException managerNotFoundExeption){
        HttpStatus status =HttpStatus.NOT_FOUND;
        if (managerNotFoundExeption.getClass().isAnnotationPresent(ResponseStatus.class)){
            status =
                    managerNotFoundExeption.getClass().getAnnotation(
                            ResponseStatus.class
                    ).value();
        }
        RestErrorResponse response =new RestErrorResponse(status.value(), managerNotFoundExeption.getMessage());
        return new ResponseEntity<>(response, status);
    }
    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> hangleDepartmentNotFound(DepartmentNotFoundException departmentNotFoundExeption){
        HttpStatus status =HttpStatus.NOT_FOUND;
        if (departmentNotFoundExeption.getClass().isAnnotationPresent(ResponseStatus.class)){
            status =
                    departmentNotFoundExeption.getClass().getAnnotation(
                            ResponseStatus.class
                    ).value();
        }
        RestErrorResponse response =new RestErrorResponse(status.value(), departmentNotFoundExeption.getMessage());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> hangleEmployeeNotFound(EmployeeNotFoundException employeeNotFoundExeption){
        HttpStatus status =HttpStatus.NOT_FOUND;
        if (employeeNotFoundExeption.getClass().isAnnotationPresent(ResponseStatus.class)){
            status =
                    employeeNotFoundExeption.getClass().getAnnotation(
                            ResponseStatus.class
                    ).value();
        }
        RestErrorResponse response =new RestErrorResponse(status.value(), employeeNotFoundExeption.getMessage());
        return new ResponseEntity<>(response, status);
    }



}
