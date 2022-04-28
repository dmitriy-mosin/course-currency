package com.example.coursecurrency.ecb.client;


import com.example.coursecurrency.ecb.client.dto.CourseEcbCube;
import com.example.coursecurrency.ecb.client.dto.Envelope;
import com.example.coursecurrency.error.exception.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Component
@CacheConfig(cacheNames = {"courseEcb"})
public class CourseEcbClient {

    @Value("${URL.ecbClient}")
    private String URL;

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(cacheNames = {"courseEcb"})
    public List<CourseEcbCube> getCourse() {
        Envelope envelope = restTemplate.getForObject(URL, Envelope.class);
        if (Optional.ofNullable(envelope).isEmpty()) {
            throw new CourseNotFoundException("Course ECB Not Found");
        }
        return envelope.getCubeMain().getCube().getCourseEcbCubes();
    }
}
