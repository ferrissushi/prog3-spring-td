package com.ferrissushi.springintro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ferrissushi.springintro.entity.Student;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public List<Student> findAllStudent() {
        return students;
    }

    public List<Student> save(List<Student> studentsToCreate) {
        studentsToCreate.forEach((Student studentToCreate) -> {
            students.add(studentToCreate);
        });
        return students;
    }
}
