package com.spring.demo.dto;

/**
 * Error representation
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
public class ErrorDto {

    private String message;

    public ErrorDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
