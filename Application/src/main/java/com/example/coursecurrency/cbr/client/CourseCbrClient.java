package com.example.coursecurrency.cbr.client;


import com.example.coursecurrency.cbr.client.dto.ValCurs;
import com.example.coursecurrency.cbr.client.dto.Valute;
import com.example.coursecurrency.exception.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
@CacheConfig(cacheNames = {"courseCbr"})
public class CourseCbrClient {

    @Value("${URL.cbrClient}")
    private String URL;

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable
    public List<Valute> getCourse() {
        ValCurs valCurs = restTemplate.getForObject(URL, ValCurs.class);
        if (valCurs == null) {
            throw new CourseNotFoundException("Course CBR Not Found");
        }
        valCurs.getValute().stream().forEach(valute -> {
            valute.setRate(Double.parseDouble(valute.getValue().replace(",", ".")));
        });
        return valCurs.getValute();
    }
}
