package com.defrag.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller advice to translate the server side exceptions
 * to client-friendly errors.
 */
@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionTranslator {

}
