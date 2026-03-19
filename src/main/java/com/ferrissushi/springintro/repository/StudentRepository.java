package com.ferrissushi.springintro.repository;

import java.util.List;

import com.ferrissushi.springintro.entity.Student;

public interface StudentRepository {

    List<Student> findAllStudent();

}
