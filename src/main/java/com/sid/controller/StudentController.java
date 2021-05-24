package com.sid.controller;

import com.sid.dto.StudentDto;
import com.sid.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/students")
    @ApiOperation("load all students")
    @ApiResponse(code=200,
            message="All students including the following properties :")
    public List<StudentDto> findAllStudent(){
        return  studentService.findAllStudent();
    }

    @GetMapping(path = "/students/{id}")
    @ApiOperation("Load students By Id")
    public StudentDto findById(@PathVariable(name = "id")Long id){
        return studentService.findById(id);
    }

    @PostMapping(path = "/students")
    @ApiOperation("create student")
    public StudentDto save(@RequestBody StudentDto dto){
        return studentService.save(dto);
    }
}
