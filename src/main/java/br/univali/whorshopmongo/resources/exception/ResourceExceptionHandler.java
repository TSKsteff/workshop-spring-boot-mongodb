package br.univali.whorshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.univali.whorshopmongo.service.exe.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest servletRequest){
		
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		StandarError standarError = new StandarError(System.currentTimeMillis(), httpStatus.value(), "não encontrado", e.getMessage(), servletRequest.getRequestURI());
		return ResponseEntity.status(httpStatus).body(standarError);
	}
}
