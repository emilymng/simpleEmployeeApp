package com.emilymng.firstapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name="Employees")
@Data
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message="First Name cannot be blank. It is mandatory.")
    private String firstName;

    @NotBlank(message="First Name cannot be blank. It is mandatory.")
    private String lastName;

    private String email;
}
