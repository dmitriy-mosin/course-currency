package com.example.coursecurrency.cbr.client;


import com.example.coursecurrency.cbr.client.dto.Currency;
import com.example.coursecurrency.cbr.client.dto.ValCurs;
import com.example.coursecurrency.error.exception.CourseNotFoundException;
import com.example.coursecurrency.error.exception.CourseParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Component
@CacheConfig
public class CourseCbrClient {

    @Value("${URL.cbrClient}")
    private String URL;

    private final RestTemplate restTemplate = new RestTemplate();

    private final NumberFormat cbrFormat = NumberFormat.getNumberInstance(Locale.FRANCE);

    @Cacheable(cacheNames = {"courseCbr"})
    public List<Currency> getCourse() {
        ValCurs valCurs = restTemplate.getForObject(URL, ValCurs.class);
        Optional.ofNullable(valCurs).orElseThrow(() -> new CourseNotFoundException("Course CBR Not Found"));
        valCurs.getCurrencies().forEach(valute -> {
            try {
                valute.setRate(cbrFormat.parse(valute.getValue()).doubleValue());
            } catch (ParseException e) {
                throw new CourseParseException(e.getMessage());
            }
        });
        return valCurs.getCurrencies();
    }
}
