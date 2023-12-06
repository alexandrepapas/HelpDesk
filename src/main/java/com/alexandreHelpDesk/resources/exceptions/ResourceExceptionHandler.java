package com.alexandreHelpDesk.resources.exceptions;

import com.alexandreHelpDesk.execptions.DataIntegrityViolationException;
import com.alexandreHelpDesk.execptions.ObjectNotFoundExecpetion;
import com.alexandreHelpDesk.execptions.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundExecpetion.class)
    public ResponseEntity<StandardError> objectnotFoundExcpetion(ObjectNotFoundExecpetion ex, HttpServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),"Objeto  não Encontrado ", ex.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),"Violacão de Dados  ", ex.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErros(MethodArgumentNotValidException ex, HttpServletRequest request){
        ValidationError errors = new ValidationError (System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(), "Validation Error", "ERRO VALIDAÇÃO DE CAMPOS", request.getRequestURI());

        for (FieldError x: ex.getBindingResult().getFieldErrors()){
            errors.addError(x.getField(),x.getDefaultMessage());
        }

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
