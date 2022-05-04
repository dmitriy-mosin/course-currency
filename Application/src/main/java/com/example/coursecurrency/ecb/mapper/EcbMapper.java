package com.example.coursecurrency.ecb.mapper;


import com.example.coursecurrency.ecb.client.dto.CourseEcbCube;
import com.example.coursecurrency.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EcbMapper {

    Course toCourse(CourseEcbCube courseEcbCube);

}
