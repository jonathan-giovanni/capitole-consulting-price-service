package com.capitoleconsulting.price.service.infrastructure.adapter.loader;

import com.capitoleconsulting.price.service.domain.exception.LoadPriceException;
import com.capitoleconsulting.price.service.domain.model.Price;
import com.capitoleconsulting.price.service.domain.port.LoadPriceRepository;
import org.apache.commons.csv.CSVParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.apache.commons.csv.CSVFormat.DEFAULT;

/**
 * @author Jonathan Giovanni Hernandez
 * @company Finansoportes Consulting
 * @created 27/02/2023
 */
@Component
public class CsvLoaderRepository implements LoadPriceRepository {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Value("${initial-data.path}")
    private String dataPath;

    @Override
    public Stream<Price> loadPrices() throws LoadPriceException {
        log.info("Loading CSV from path: {}", dataPath);

        var file = new File(dataPath);
        try( var fileInputStream = new FileInputStream(file);
             var reader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
             var parser = new CSVParser(reader, DEFAULT.builder().setHeader("brandId","startDate","endDate","priceList","productId","priority","price","currency","updatedAt").setSkipHeaderRecord(true).setTrim(true).build());
         ) {

            var cvsData = parser.getRecords();
            return cvsData.stream().map(csv -> new Price(
                    Long.valueOf(csv.get("brandId")),
                    LocalDateTime.parse(csv.get("startDate")),
                    LocalDateTime.parse(csv.get("endDate")),
                    Long.valueOf(csv.get("priceList")),
                    Long.valueOf(csv.get("productId")),
                    Integer.valueOf(csv.get("priority")),
                    new BigDecimal(csv.get("price")),
                    csv.get("currency"),
                    LocalDateTime.parse(csv.get("updatedAt"))
            ));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ERROR LOADING CVS: {} MSG: {}", dataPath, e.getMessage());
            throw new LoadPriceException();
        }
    }
}
