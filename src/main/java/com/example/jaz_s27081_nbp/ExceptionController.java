package com.example.jaz_s27081_nbp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<String> handleCurrencyNotFoundException(CurrencyNotFoundException currencyNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Currency not found");
    }

    @ExceptionHandler(CurrencyBadRequestException.class)
    public ResponseEntity<String> handleCurrencyBadRequestException(CurrencyBadRequestException currencyBadRequestException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency bad request");
    }
}
