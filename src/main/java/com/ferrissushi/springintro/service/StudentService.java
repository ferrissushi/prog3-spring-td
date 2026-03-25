package com.ferrissushi.springintro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ferrissushi.springintro.entity.Student;
import com.ferrissushi.springintro.exception.BadRequestException;
import com.ferrissushi.springintro.repository.StudentRepository;
import com.ferrissushi.springintro.validator.StudentValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentValidator studentValidator;

    public List<Student> findAllStudents() {
        return studentRepository.findAllStudent();
    }

    public List<Student> save(List<Student> studentsToCreate) {
        studentsToCreate.forEach(studentToCreate -> {
            studentValidator.setStudent(studentToCreate);
            if (!studentValidator.checkValidation().isValid()) {
                throw new BadRequestException(studentValidator.checkValidation().missingField() + " is missing");
            }
        });
        return studentRepository.save(studentsToCreate);
    }

}
