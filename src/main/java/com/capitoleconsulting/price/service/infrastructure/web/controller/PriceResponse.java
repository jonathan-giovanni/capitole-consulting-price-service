package com.capitoleconsulting.price.service.infrastructure.web.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Jonathan Giovanni Hernandez
 * @created 27/02/2023
 */
public record PriceResponse(
        @Schema(description = "Brand identifier",example = "1")
        @JsonProperty Long brandId,
        @Schema(description = "Price start date",example = "2022-02-26T20:53:04.663Z")
        @JsonProperty LocalDateTime startDate,
        @Schema(description = "Price start date",example = "2023-02-26T20:53:04.663Z")
        @JsonProperty LocalDateTime endDate,
        @Schema(description = "Price list identifier",example = "1")
        @JsonProperty Long priceList,
        @Schema(description = "Product identifier",example = "35455")
        @JsonProperty Long productId,
        @Schema(description = "Price priority",example = "0")
        @JsonProperty Integer priority,
        @Schema(description = "Price value with decimals",example = "30.50")
        @JsonProperty BigDecimal price,
        @Schema(description = "Money currency",example = "EUR")
        @JsonProperty String currency,
        @Schema(description = "Updated at time",example = "2023-02-26T20:53:04.663Z")
        @JsonProperty LocalDateTime updatedAt
) {
    public PriceResponse(Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId, Integer priority, BigDecimal price, String currency, LocalDateTime updatedAt) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
        this.updatedAt = updatedAt;
    }
}
