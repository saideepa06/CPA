package com.project.developer.cpa.security;

import com.project.developer.cpa.exception.CpaException;
import com.project.developer.cpa.model.ApiErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

import static java.lang.String.format;

@ControllerAdvice
public class CpaExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(CpaExceptionHandler.class);

    public CpaExceptionHandler(){
        log.info("Init CpaExceptionHandler");
    }

    @ExceptionHandler({CpaException.class})
    public ResponseEntity<ApiErrorResponse> handleCpaException(CpaException cpaException, WebRequest webRequest){
        log.error("A runtime exception occured while serving the webrequest {}", webRequest, cpaException);
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setErrors(List.of(format("There was an unexpected error processing the request: %s", cpaException)));
        return new ResponseEntity<>(apiErrorResponse, cpaException.getHttpStatus());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiErrorResponse> handleRuntimeException(RuntimeException runtimeException, WebRequest webRequest){
        log.error("A runtime exception occured while serving the webrequest {}", webRequest, runtimeException);
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setErrors(List.of(format("There was an unexpected error processing the request: %s", runtimeException)));
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
