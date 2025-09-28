package com.emilymng.firstapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    //@NotNull for non-string types
    @NotNull(message="Date of Birth cannot be blank.")
    //Jackson will deserialize.serialize LocalDate using the pattern
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private LocalDate dateOfBirth;

    @NotNull(message="Hire Date cannot be blank.")
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private LocalDate hireDate;

    @NotNull(message="Salary cannot be blank.")
    private double salary;

    private String email;
}
