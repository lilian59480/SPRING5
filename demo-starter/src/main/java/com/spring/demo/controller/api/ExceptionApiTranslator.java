package com.spring.demo.controller.api;

import com.spring.demo.dto.ErrorDto;
import com.spring.demo.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Transform Exceptions into JSON
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@ControllerAdvice("com.spring.demo.controller.api")
public class ExceptionApiTranslator {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionApiTranslator.class);

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody()
    public ErrorDto handleNotFoundException(Exception ex) {
        ExceptionApiTranslator.LOG.error("Not Found exception", ex);
        return new ErrorDto(ex.getMessage());
    }

}
