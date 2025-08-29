package com.emilymng.firstapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Table(name="Employees")
@Data
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message="First Name cannot be blank.")
    private String firstName;

    @NotBlank(message="Last Name cannot be blank.")
    private String lastName;

    @NotBlank(message="department cannot be blank.")
    private String department;

    @NotBlank(message="Job Title cannot be blank.")
    private String jobTitle;

    //TODO: serialize/deserialize with JSON annotations
    @NotBlank(message="Date of Birth cannot be blank.")
    private LocalDate dateOfBirth;

    //TODO: serialize/deserialize with JSON annotations
    @NotBlank(message="Hire Date cannot be blank.")
    private LocalDate hireDate;

    @NotBlank(message="Salary cannot be blank.")
    private double salary;

    private String email;
}
