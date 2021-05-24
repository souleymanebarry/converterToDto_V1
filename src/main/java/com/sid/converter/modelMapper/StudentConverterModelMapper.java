package com.sid.converter.modelMapper;


import com.sid.dto.StudentDto;
import com.sid.entities.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverterModelMapper {

    public StudentDto entityToDto(Student student){
        ModelMapper mapper= new ModelMapper();
        return mapper.map(student,StudentDto.class);
    }

    public List<StudentDto> entitiesToDtos(List<Student> student){
        return student.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }

    public Student dtoToEntity(StudentDto dto){
        ModelMapper mapper= new ModelMapper();
        return mapper.map(dto,Student.class);
    }

    public List<Student> dtoToEntities(List<StudentDto> dtos){
        return dtos.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());
    }
}
