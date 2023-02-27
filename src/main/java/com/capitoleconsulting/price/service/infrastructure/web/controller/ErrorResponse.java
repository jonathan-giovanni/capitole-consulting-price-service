package com.capitoleconsulting.price.service.infrastructure.web.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * @author Jonathan Giovanni Hernandez
 * @created 27/02/2023
 */
public record ErrorResponse(
        @Schema(description = "Error timestamp",example = "2023-02-26T20:53:04.663Z")
        @JsonProperty LocalDateTime timestamp,
        @Schema(description = "Error status code",example = "404")
        @JsonProperty Integer status,
        @Schema(description = "Error title",example = "Price not found")
        @JsonProperty String error,
        @Schema(description = "Error message",example = "Price not found with the given id")
        @JsonProperty String message,
        @Schema(description = "Requested path",example = "/v1/price/")
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
