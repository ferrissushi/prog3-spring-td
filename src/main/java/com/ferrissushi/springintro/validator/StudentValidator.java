package com.ferrissushi.springintro.validator;

import com.ferrissushi.springintro.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class StudentValidator {
    private Student student;

    public StudentValidatorResponse checkValidation() {
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
