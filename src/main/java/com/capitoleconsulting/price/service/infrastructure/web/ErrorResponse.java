package com.capitoleconsulting.price.service.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * @author Jonathan Giovanni Hernandez
 * @company Finansoportes Consulting
 * @created 27/02/2023
 */
public record ErrorResponse(
        @JsonProperty LocalDateTime timestamp,
        @JsonProperty Integer status,
        @JsonProperty String error,
        @JsonProperty String message,
        @JsonProperty String path
) {
    public ErrorResponse(LocalDateTime timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

}
