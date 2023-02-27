package com.capitoleconsulting.price.service.infrastructure.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



/**
 * @author Jonathan Giovanni Hernandez
 * @created 27/02/2023
 */
@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class PriceControllerTest {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ObjectMapper mapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    @Autowired
    private MockMvc mockMvc;

    private PriceResponse call_get_method_and_print_data(String product,String brand,String date) throws Exception {
        log.info("Test with product: {} , brand: {} , date: {}",product,brand,date);
        var result = mockMvc.perform(get("/api/v1/price/product/"+product+"/brand/"+brand+"/date/"+date)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        var object = mapper.readValue(result.getResponse().getContentAsString(),PriceResponse.class);

        log.info("object: {}",object);
        return object;
    }

    @Test
    void test01Request_2020_06_14_15_00_00_product_35455_brand_1_expected_priceList_2_price_35_50() throws Exception {
        var product = "35455";
        var brand = "1";
        var date = "2020-06-14T10:00:00";
        var expectedPrice = BigDecimal.valueOf(35.50);
        log.info("Expected price: {}",expectedPrice);
        var priceResponse = call_get_method_and_print_data(product,brand,date);

        Assertions.assertEquals(expectedPrice.stripTrailingZeros(),priceResponse.price().stripTrailingZeros());
    }

    @Test
    void test02Request_2020_06_14_16_00_00_product_35455_brand_1_expected_priceList_2_price_25_45() throws Exception {
        var product = "35455";
        var brand = "1";
        var date = "2020-06-14T16:00:00";
        var expectedPrice = BigDecimal.valueOf(25.45);
        log.info("Expected price: {}",expectedPrice);
        var priceResponse = call_get_method_and_print_data(product,brand,date);

        Assertions.assertEquals(expectedPrice.stripTrailingZeros(),priceResponse.price().stripTrailingZeros());
    }

    @Test
    void test03Request_2020_06_14_21_00_00_product_35455_brand_1_expected_priceList_2_price_35_50() throws Exception {
        var product = "35455";
        var brand = "1";
        var date = "2020-06-14T21:00:00";
        var expectedPrice = BigDecimal.valueOf(35.50);
        log.info("Expected price: {}",expectedPrice);
        var priceResponse = call_get_method_and_print_data(product,brand,date);

        Assertions.assertEquals(expectedPrice.stripTrailingZeros(),priceResponse.price().stripTrailingZeros());
    }

    @Test
    void test04Request_2020_06_15_10_00_00_product_35455_brand_1_expected_priceList_2_price_30_50() throws Exception {
        var product = "35455";
        var brand = "1";
        var date = "2020-06-15T10:00:00";
        var expectedPrice = BigDecimal.valueOf(30.50);
        log.info("Expected price: {}",expectedPrice);
        var priceResponse = call_get_method_and_print_data(product,brand,date);

        Assertions.assertEquals(expectedPrice.stripTrailingZeros(),priceResponse.price().stripTrailingZeros());
    }

    @Test
    void test05Request_2020_06_16_21_00_00_product_35455_brand_1_expected_priceList_2_price_38_95() throws Exception {
        var product = "35455";
        var brand = "1";
        var date = "2020-06-16T21:00:00";
        var expectedPrice = BigDecimal.valueOf(38.95);
        log.info("Expected price: {}",expectedPrice);
        var priceResponse = call_get_method_and_print_data(product,brand,date);

        Assertions.assertEquals(expectedPrice.stripTrailingZeros(),priceResponse.price().stripTrailingZeros());
    }

}
