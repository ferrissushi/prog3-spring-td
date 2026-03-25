package com.ferrissushi.springintro.validator;

import com.ferrissushi.springintro.entity.Student;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentValidator {
    private Student student;

    public StudentValidatorResponse isValid() {
        if (student.getFirstname() == null || student.getFirstname().isBlank()) {
            return new StudentValidatorResponse("firstname", false);
        }
        if (student.getLastname() == null || student.getLastname().isBlank()) {
            return new StudentValidatorResponse("lastname", false);
        }
        if (student.getReference() == null || student.getReference().isBlank()) {
            return new StudentValidatorResponse("reference", false);
        }
        return new StudentValidatorResponse(null, true);
    }

    public record StudentValidatorResponse(String missingField, Boolean isValid) {
    }
}
