package com.ferrissushi.springintro.validator;

import org.springframework.stereotype.Component;

import com.ferrissushi.springintro.entity.Student;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Component
@NoArgsConstructor
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
