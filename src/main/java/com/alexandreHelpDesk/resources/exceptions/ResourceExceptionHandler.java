package com.alexandreHelpDesk.resources.exceptions;

import com.alexandreHelpDesk.execptions.ObjectNotFoundExecpetion;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
