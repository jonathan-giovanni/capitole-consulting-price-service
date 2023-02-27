package com.capitoleconsulting.price.service;

import com.capitoleconsulting.price.service.domain.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Stream;

public class PriceTestStub {

    public static final LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T10:00:00");
    public static final Long existingProductId = 35455L;
    public static final Long nonExistProductId = 123L;
    public static final Long existingBrandId = 1L;

    public static final Price expectedPrice = new Price(1L,LocalDateTime.parse("2020-06-14T00:00:00"),LocalDateTime.parse("2020-12-31T23:59:59"),1L,35455L,0, BigDecimal.valueOf(35.50),"EUR",LocalDateTime.parse("2023-02-27T10:00:00"));
    public static final Stream<Price> expectedPrices = new ArrayList<Price>(){{add(new Price(1L,LocalDateTime.parse("2020-06-14T00:00:00"),LocalDateTime.parse("2020-12-31T23:59:59"),1L,35455L,0, BigDecimal.valueOf(35.50),"EUR",LocalDateTime.parse("2023-02-27T10:00:00")));}}.stream();


}
