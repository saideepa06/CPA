package com.project.developer.cpa.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CpaException extends Exception{

    private final HttpStatus httpStatus;
    private final List<String> messages;

    public CpaException(String message){
        this(List.of(message));
    }
    public CpaException(List<String> messages){
        this.messages = messages;
        this.httpStatus = null;
    }

    public CpaException(List<String> messages, Throwable cause){
        this(HttpStatus.INTERNAL_SERVER_ERROR, messages, cause);
    }

    public CpaException(String message, Throwable cause){
        this(List.of(message), cause);
    }

    public CpaException(HttpStatus httpStatus, String message, Throwable cause){
        this(httpStatus,List.of(message),cause);
    }

    public CpaException(HttpStatus httpStatus, List<String> messages, Throwable cause){
        super(join(messages),cause);
        this.messages = messages;
        this.httpStatus = httpStatus;
    }

    public CpaException(HttpStatus httpStatus, List<String> messages) {
        this(httpStatus, messages, null);
    }

    public CpaException(HttpStatus httpStatus, String message) {
        this(httpStatus, List.of(message));
    }

    public static String join(List<String> messages){
        messages = (messages == null ? Collections.emptyList(): messages);
        return (messages).stream().collect(Collectors.joining("\n"));
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }

    public List<String> getMessages(){
        return messages;
    }
}
