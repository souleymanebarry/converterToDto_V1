package com.sid;

import com.sid.dao.StudentRepository;
import com.sid.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner start(StudentRepository studentRepository){
        return args -> {
            studentRepository.save(new Student(null,"sangare","msangare","1234",new Date(),null));
            studentRepository.save(new Student(null,"barry","s.barry","1234",new Date(),null));
            studentRepository.save(new Student(null,"lamine","l.camara","1234",new Date(),null));
            studentRepository.save(new Student(null,"dupond","louise.dupond","1234",new Date(),null));
        };
    }

}
