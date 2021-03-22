package com.latam.millas.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.latam.millas.Model.ErrorInfo;

@ControllerAdvice
public class ErroresController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<ErrorInfo> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
	       ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
	       return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	   }
}
