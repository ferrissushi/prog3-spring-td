package com.ferrissushi.springintro.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String reference;
    private String firstname;
    private String lastname;
    private Integer age;

    @Override
    public String toString() {
        return this.firstname;
    }
}
