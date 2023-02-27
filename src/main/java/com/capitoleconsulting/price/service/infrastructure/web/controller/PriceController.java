package com.capitoleconsulting.price.service.infrastructure.web.controller;

import com.capitoleconsulting.price.service.application.search.SearchPrice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Jonathan Giovanni Hernandez
 * @company Finansoportes Consulting
 * @created 27/02/2023
 */
@RestController
@RequestMapping("/api/v1/price/")
public class PriceController {

    private final SearchPrice searchPrice;

    public PriceController(SearchPrice searchPrice) {
        this.searchPrice = searchPrice;
    }

    @Operation(summary="Get price of product in specified date",description="Get price of product by productId, brandId and applicationDate in range of prices")
    @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PriceResponse.class)))
    @ApiResponse(responseCode = "404", description = "Price Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    @GetMapping("/product/{productId}/brand/{brandId}/date/{applicationDate}")
    public ResponseEntity<PriceResponse> findProductPrice(@PathVariable Long productId, @PathVariable Long brandId, @PathVariable LocalDateTime applicationDate) {
        var data = searchPrice.execute(applicationDate,productId,brandId);
        return new ResponseEntity<>(new PriceResponse(
                data.brandId(),
                data.startDate(),
                data.endDate(),
                data.priceList(),
                data.productId(),
                data.priority(),
                data.price(),
                data.currency(),
                data.updatedAt()
        ), HttpStatus.OK);
    }


}
