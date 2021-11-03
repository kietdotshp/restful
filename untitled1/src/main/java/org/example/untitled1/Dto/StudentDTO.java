package org.example.untitled1.Dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDTO {
    Integer id;
    String fullName;
    String birthday;
    String className;
    String major;
    String hometown;
    String gender;
    Double averageMark;

}
