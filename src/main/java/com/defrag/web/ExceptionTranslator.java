package com.defrag.web;

import com.defrag.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller advice to translate the server side exceptions
 * to client-friendly errors.
 */
@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(EntityNotFoundException.class)
    public void entityNotFound(final EntityNotFoundException e,
                               final HttpServletResponse response) throws IOException {
        log.debug(e.getMessage(), e);
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
