package com.capitoleconsulting.price.service.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * @author Jonathan Giovanni Hernandez
 * @company Finansoportes Consulting
 * @created 27/02/2023
 */
public class ErrorResponse {
    @JsonProperty
    private final LocalDateTime timestamp;
    @JsonProperty
    private final Integer status;
    @JsonProperty
    private final String error;
    @JsonProperty
    private final String message;
    @JsonProperty
    private final String path;

    public ErrorResponse(LocalDateTime timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

}
