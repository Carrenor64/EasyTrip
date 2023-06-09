package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {
        @ExceptionHandler(LugaresNotFoundException.class)
        public ResponseEntity<?> handleEmpleadoNotFound(
                        LugaresNotFoundException ex, WebRequest request) {
                ExcepcionBody body = new ExcepcionBody(LocalDateTime.now(),
                                HttpStatus.NOT_FOUND, ex.getMessage(),
                                ((ServletWebRequest) request).getRequest().getRequestURI().toString());
                return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(LugaresEmptyException.class)
        public ResponseEntity<?> handleEmptyEmpleados(
                        LugaresEmptyException ex, WebRequest request) {
                ExcepcionBody body = new ExcepcionBody(LocalDateTime.now(),
                                HttpStatus.NOT_FOUND, ex.getMessage(),
                                ((ServletWebRequest) request).getRequest().getRequestURI().toString());
                return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(ValoracionNotFound.class)
        public ResponseEntity<?> handleValoracionNotFound(
                        ValoracionNotFound ex, WebRequest request) {
                ExcepcionBody body = new ExcepcionBody(LocalDateTime.now(),
                                HttpStatus.NOT_FOUND, ex.getMessage(),

                                ((ServletWebRequest) request).getRequest().getRequestURI());
                return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
        }

        @Override
        protected ResponseEntity<Object> handleExceptionInternal(
                        Exception ex, @Nullable Object body, org.springframework.http.HttpHeaders headers,
                        HttpStatus status, WebRequest request) {
                ExcepcionBody myBody = new ExcepcionBody(LocalDateTime.now(),
                                HttpStatus.NOT_FOUND, ex.getMessage(),
                                ((ServletWebRequest) request).getRequest().getRequestURI().toString());
                return ResponseEntity.status(status).headers(headers).body(myBody);
        }
}
