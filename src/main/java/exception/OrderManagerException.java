package exception;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dto.ErrorInfo;

public class OrderManagerException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public OrderManagerException(String message) {
		super(message);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> handleEx(Exception exception){
		System.out.println(exception);
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
		//MethodArg...Exception => happens when REQUESTBODY validation fails
		//ConstraintV...Exception => happens when PATHVARIABLE validation fails
	public ResponseEntity<ErrorInfo> exHandle(Exception e){
		
		e.printStackTrace();
		ErrorInfo err = new ErrorInfo();
		err.setErrorCode(HttpStatus.BAD_REQUEST.value());
		String errorMessage="";
		
		if(e instanceof MethodArgumentNotValidException) {
			errorMessage = ((MethodArgumentNotValidException) e).getBindingResult()
					.getAllErrors().stream().map(er->er.getDefaultMessage())
					.collect(Collectors.joining(", "));
		}
		
		if(e instanceof ConstraintViolationException) {
			errorMessage = ((ConstraintViolationException) e).getConstraintViolations().stream()
					.map(er->er.getMessage())
					.collect(Collectors.joining(", "));
		}
		
		err.setErrorMessage(errorMessage);
		
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.BAD_REQUEST);
	}
}
