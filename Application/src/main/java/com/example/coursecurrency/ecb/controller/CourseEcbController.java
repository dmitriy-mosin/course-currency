package com.example.coursecurrency.ecb.controller;


import com.example.coursecurrency.ecb.mapper.EcbListMapper;
import com.example.coursecurrency.controller.CourseEcbApiDelegate;
import com.example.coursecurrency.ecb.client.CourseEcbClient;
import com.example.coursecurrency.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseEcbController implements CourseEcbApiDelegate {

    private final CourseEcbClient client;
    private final EcbListMapper mapper;

    @Override
    public ResponseEntity<List<Course>> getCourseEcb() {
        return ResponseEntity.ok(mapper.toCourseList(client.getCourse()));
    }
}
