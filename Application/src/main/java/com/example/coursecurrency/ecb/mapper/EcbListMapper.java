package com.example.coursecurrency.ecb.mapper;


import com.example.coursecurrency.ecb.client.dto.CourseEcbCube;
import com.example.coursecurrency.model.Course;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = EcbMapper.class)
public interface EcbListMapper {

    List<Course> toCourseList(List<CourseEcbCube> courseEcbCubes);

}
