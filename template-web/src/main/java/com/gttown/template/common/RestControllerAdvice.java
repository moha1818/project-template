package com.gttown.template.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gttown.common.support.exception.BadRequestException;
import com.gttown.common.support.exception.NotFoundException;
import com.gttown.common.support.exception.PermissionException;
import com.gttown.common.support.web.api.common.RestResponse;
import com.gttown.common.support.web.validate.ValidateException;
import org.apache.shiro.cas.CasAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

/**
 * Created by hbprotoss on 8/3/16.
 */
@ControllerAdvice(basePackages = {"com.gttown.enterprise.api", "com.gttown.user.api"})
public class RestControllerAdvice {
    @ExceptionHandler(CasAuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public RestResponse<String> handleUnauthorizedException(Exception e) {
        return new RestResponse<>(HttpStatus.UNAUTHORIZED.value(), e.getMessage(), "");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse<String> handleException(Exception e) {
        return new RestResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), "");
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse<String> handleSQLException(Exception e) {
        return new RestResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Database Error", "");
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleBadRequestException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleHttpMessageNotReadableExceptionException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    @ExceptionHandler(PermissionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public RestResponse<String> handlePermissionException(Exception e) {
        return new RestResponse<>(HttpStatus.FORBIDDEN.value(), e.getMessage(), "");
    }

    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleJsonProcessingException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public RestResponse<String> handleNotFoundException(Exception e) {
        return new RestResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage(), "");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleMissingParamException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse<String> handleMethodArgumentNotValidException(Exception e) {
        return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
    }

    @ExceptionHandler(ValidateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public void handleValidateExceptionException(Exception e, HttpServletResponse response, Writer writer) throws IOException {
        response.addHeader("Content-Type", "application/json");
        writer.write(e.getMessage());
    }

}
