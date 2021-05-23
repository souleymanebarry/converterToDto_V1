package com.sid.converter;


import com.sid.dto.StudentDto;
import com.sid.entities.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {

    public StudentDto entityToDto(Student student){
        StudentDto dto= new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setUsername(student.getUsername());
        dto.setPassword(student.getPassword());
        return dto;
    }

    public List<StudentDto> entitiesToDtos(List<Student> student){
        return student.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }

    public Student dtoToEntity(StudentDto dto){
      Student student=new Student();
      student.setId(dto.getId());
      student.setName(dto.getName());
      student.setUsername(dto.getUsername());
      student.setPassword(dto.getPassword());
      return student;
    }

    public List<Student> dtoToEntities(List<StudentDto> dtos){
        return dtos.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());
    }
}
