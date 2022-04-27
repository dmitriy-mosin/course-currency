package com.example.coursecurrency.cbr.mapper;


import com.example.coursecurrency.cbr.client.dto.Valute;
import com.example.coursecurrency.model.Course;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = CbrMapper.class)
public interface CbrListMapper {

    List<Course> toCourseList(List<Valute> valuteList);
}
