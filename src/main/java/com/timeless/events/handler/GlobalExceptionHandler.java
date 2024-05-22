package com.timeless.events.handler;

import com.timeless.events.dto.handler.CustomErrorResponse;
import com.timeless.events.handler.exceptions.BaseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BaseException.class})
    private ResponseEntity<Object> handleErrosCode(Exception ex, WebRequest request) {
        //BaseException errorCodeException = (BaseException) e;
        CustomErrorResponse error = new CustomErrorResponse();
        error.setError(e.getMessage());

        switch (ex.getError()) {
            case :
                status = HttpStatus.NOT_FOUND;
                break;
            case INVALID_REQUEST:
                status = HttpStatus.BAD_REQUEST;
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setCode(errorCodeException.getErrorCode().getCode());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, status , HttpStatus.BAD_REQUEST, request);
        return handleExceptionInternal(ex, error, headers, status, request);
    }

}
