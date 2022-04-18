package com.india.blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.india.blog.paylod.ResponseApi;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseApi ResourseNotFoundExceptionHandler(ResourseNotFoundException exe) {
		
		log.info(exe.getMessage());
		
		return new ResponseApi("resourse not found","resourse not found with the perticular id");
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		
		Map<String , String> resp = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String field = ((FieldError)error).getField();
			String defaultMessage = error.getDefaultMessage();
			
			resp.put(field, defaultMessage);
			
			
		});
		
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
		
		
		
	}
	
}
