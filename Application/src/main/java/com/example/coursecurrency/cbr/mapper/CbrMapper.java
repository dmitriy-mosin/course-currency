package com.example.coursecurrency.cbr.mapper;


import com.example.coursecurrency.cbr.client.dto.Valute;
import com.example.coursecurrency.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CbrMapper {

    Course toCourse(Valute valute);
}
