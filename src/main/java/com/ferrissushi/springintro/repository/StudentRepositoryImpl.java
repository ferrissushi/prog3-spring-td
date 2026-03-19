package com.ferrissushi.springintro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ferrissushi.springintro.entity.Student;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    private List<Student> students = new ArrayList<>();

    @Override
    public List<Student> findAllStudent() {
        return students;
    }

    @Override
    public List<Student> save(List<Student> studentsToCreate) {
        studentsToCreate.forEach((Student studentToCreate) -> {
            students.add(studentToCreate);
        });
        return students;
    }

}
