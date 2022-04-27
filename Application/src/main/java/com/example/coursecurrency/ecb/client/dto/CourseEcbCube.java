package com.example.coursecurrency.ecb.client.dto;


import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cube", namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CourseEcbCube {

    @XmlAttribute(name = "currency")
    private String currency;

    @XmlAttribute(name = "rate")
    private double rate;
}
