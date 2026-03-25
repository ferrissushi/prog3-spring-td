package com.ferrissushi.springintro.validator;

import com.ferrissushi.springintro.entity.Student;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentValidator {
    private Student student;

    public boolean isValid() {
        if (student.getReference() == null || student.getReference().isBlank() || student.getLastname() == null
                || student.getLastname().isBlank() || student.getFirstname() == null
                || student.getFirstname().isBlank()) {
            return false;
        }
        return true;
    }
}
