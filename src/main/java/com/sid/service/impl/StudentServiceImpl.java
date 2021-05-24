package com.sid.service.impl;

import com.sid.converter.modelMapper.StudentConverterModelMapper;
import com.sid.dao.StudentRepository;
import com.sid.dto.StudentDto;
import com.sid.entities.Student;
import com.sid.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private StudentConverterModelMapper converter;

    public StudentServiceImpl(StudentRepository studentRepository, StudentConverterModelMapper converter) {
        this.studentRepository = studentRepository;
        this.converter = converter;
    }

    @Override
    public List<StudentDto> findAllStudent() {
        List<Student> students=studentRepository.findAll();
        log.info("find all students");
        return converter.entitiesToDtos(students);
    }

    @Override
    @Cacheable(value="studentCache", key = "#id")
    public StudentDto findById(Long id) {
       Student student= studentRepository.findById(id)
               .orElseThrow(()-> new IllegalArgumentException("ID: "+id+ " not exist"));
        log.info("find student by id:{}",id);
        return converter.entityToDto(student);
    }

    @Override
    public StudentDto save(StudentDto dto) {
        Student student=converter.dtoToEntity(dto);
        Student student1=studentRepository.save(student);
        return converter.entityToDto(student1);
    }
}
