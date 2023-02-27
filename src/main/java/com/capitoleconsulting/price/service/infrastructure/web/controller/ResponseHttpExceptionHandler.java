package com.capitoleconsulting.price.service.infrastructure.web.controller;

import com.capitoleconsulting.price.service.domain.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * @author Jonathan Giovanni Hernandez
 * @company Finansoportes Consulting
 * @created 27/02/2023
 */

@ControllerAdvice
public class ResponseHttpExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        var path = ((ServletWebRequest)request).getRequest().getRequestURI();
        var errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error",ex.getMessage(),path);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public final ResponseEntity<ErrorResponse> notFoundPriceException(Exception ex, WebRequest request) {
        var path = ((ServletWebRequest)request).getRequest().getRequestURI();
        var errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),"Not Found Price","Not found price with the given params",path);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
