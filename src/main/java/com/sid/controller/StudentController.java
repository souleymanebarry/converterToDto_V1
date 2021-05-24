package com.sid.controller;

import com.sid.converter.modelMapper.StudentConverterModelMapper;
import com.sid.dao.StudentRepository;
import com.sid.dto.StudentDto;
import com.sid.entities.Student;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StudentController {

    private StudentRepository studentRepository;
    private StudentConverterModelMapper converter;

    public StudentController(StudentRepository studentRepository, StudentConverterModelMapper converter) {
        this.studentRepository = studentRepository;
        this.converter = converter;
    }

    @GetMapping(path = "/students")
    @ApiOperation("load all students")
    @ApiResponse(code=200,
            message="All students including the following properties :")
    public List<StudentDto> findAllStudent(){
       List<Student> students= studentRepository.findAll();
        log.info("find all students");
        return  converter.entitiesToDtos(students);
    }

    @GetMapping(path = "/students/{id}")
    @ApiOperation("Load students By Id")
    public StudentDto findById(@PathVariable(name = "id")Long id){
     Student student= studentRepository.findById(id)
             .orElseThrow(() -> new IllegalArgumentException("Id:"+ id+" not exist"));
        log.info("find student by id:{}",id);
        return converter.entityToDto(student);
    }

    @PostMapping(path = "/students")
    @ApiOperation("create student")
    public StudentDto save(@RequestBody StudentDto dto){
        Student student=converter.dtoToEntity(dto);
        Student student2 = studentRepository.save(student);
        return converter.entityToDto(student2);
    }
}
