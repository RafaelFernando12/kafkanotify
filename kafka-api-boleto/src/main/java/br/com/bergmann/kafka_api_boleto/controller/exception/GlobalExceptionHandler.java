package br.com.bergmann.kafka_api_boleto.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { ApplicationException.class })
    public ResponseEntity<Object> applicationExceptionHandler(ApplicationException e, WebRequest request){
        var response = ErrorResponse.builder()
                .error(e.getMessage())
                .codError(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, WebRequest request){
        StringBuilder sb = new StringBuilder();
        for (FieldError item : e.getFieldErrors()) {
            String s = item.getField() + " " + item.getDefaultMessage() + " ";
            sb.append(s);
        }
        var errors = sb.toString();

        var response = ErrorResponse.builder()
                .error(errors)
                .codError(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
