package com.emilymng.firstapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
