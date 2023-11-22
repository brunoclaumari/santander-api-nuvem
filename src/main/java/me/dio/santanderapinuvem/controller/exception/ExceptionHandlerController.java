
package me.dio.santanderapinuvem.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	//Exception muito genérica
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> entityNotFound(Throwable ex, HttpServletRequest request){
		String message = "Unexpected server error, see the logs.";
		logger.error(message);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.body(message);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> entityNotFound(NoSuchElementException ex, HttpServletRequest request){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body("Entity not found");
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> accountExists(IllegalArgumentException ex, HttpServletRequest request){
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(ex.getMessage());
	}
	

}
