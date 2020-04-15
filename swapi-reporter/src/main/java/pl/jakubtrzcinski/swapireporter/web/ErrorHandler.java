package pl.jakubtrzcinski.swapireporter.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.net.ConnectException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(ConnectException.class)
    protected ResponseEntity<Object> handleConnectException(
            ConnectException ex
    ) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Could not reach Swapi, please try again latter.");

        return new ResponseEntity<>(body, HttpStatus.GATEWAY_TIMEOUT);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFoundException(
            ConnectException ex
    ) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Could not reach Swapi, please try again latter.");

        return new ResponseEntity<>(body, HttpStatus.GATEWAY_TIMEOUT);
    }
}
