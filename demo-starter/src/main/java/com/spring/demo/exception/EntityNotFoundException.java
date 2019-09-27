package com.spring.demo.exception;

/**
 * Exception raised when a result is not found
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
