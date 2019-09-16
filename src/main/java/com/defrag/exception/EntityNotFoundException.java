package com.defrag.exception;

/**
 * Cause when some entity was not found.
 */
public class EntityNotFoundException extends RuntimeException {

    private static final String ERR_MSG_PATTERN = "Entity %s with id %d was not found!";

    public EntityNotFoundException(Class<?> entityClass, long id) {
        super(String.format(ERR_MSG_PATTERN, entityClass.getSimpleName(), id));
    }
}
