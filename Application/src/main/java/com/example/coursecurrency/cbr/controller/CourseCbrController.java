package com.example.coursecurrency.cbr.controller;


import com.example.coursecurrency.cbr.client.CourseCbrClient;
import com.example.coursecurrency.cbr.mapper.CbrListMapper;
import com.example.coursecurrency.controller.CourseCbrApiDelegate;
import com.example.coursecurrency.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseCbrController implements CourseCbrApiDelegate {

    private final CourseCbrClient client;

    private final CbrListMapper mapper;

    @Override
    public ResponseEntity<List<Course>> getCourseCbr() {
        return ResponseEntity.ok(mapper.toCourseList(client.getCourse()));
    }
}
