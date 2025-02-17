package com.CDA.CollegeDirectoryApplication.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception e, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    // to handle Not found exception
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), "Validation Error",
                me.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MyErrorDetails> illegealArgumentHandler(IllegalArgumentException cnf, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimestamp(LocalDateTime.now());
        err.setMessage(cnf.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(StudentException.class)
    public ResponseEntity<MyErrorDetails> cartException(StudentException ce,WebRequest req){
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ce.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(FacultyMemberException.class)
    public ResponseEntity<MyErrorDetails> cartException(FacultyMemberException ce,WebRequest req){
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ce.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AdministratorExcepton.class)
    public ResponseEntity<MyErrorDetails> cartException(AdministratorExcepton ce,WebRequest req){
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ce.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
