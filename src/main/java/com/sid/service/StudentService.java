package com.sid.service;

import com.sid.dto.StudentDto;

import java.util.List;

public interface StudentService {

    public List<StudentDto> findAllStudent();
    public StudentDto findById(Long id);
    public StudentDto save(StudentDto dto);
}
