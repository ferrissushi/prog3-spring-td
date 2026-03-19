package com.ferrissushi.springintro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ferrissushi.springintro.entity.Student;
import com.ferrissushi.springintro.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository ;

    public List<Student> findAllStudents() {
        return studentRepository.findAllStudent();
    }

    public List<Student> save(List<Student> studentsToCreate) {
        return studentRepository.save(studentsToCreate);
    }

}
