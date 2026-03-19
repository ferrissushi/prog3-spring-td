package com.ferrissushi.springintro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ferrissushi.springintro.entity.Student;
import com.ferrissushi.springintro.repository.StudentRepositoryImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepositoryImpl studentRepositoryImpl;

    public List<Student> findAllStudents() {
        return studentRepositoryImpl.findAllStudent();
    }

    public List<Student> save(List<Student> studentsToCreate) {
        return studentRepositoryImpl.save(studentsToCreate);
    }

}
