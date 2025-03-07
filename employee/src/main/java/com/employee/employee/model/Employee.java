package com.employee.employee.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employee {
    @Id
    int id;
    String name;
    LocalDate birthday;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "VARCHAR(20)")
    Gender gender;
    BigDecimal salary;

    public enum Gender {
        Male,
        Female
    }
    @ManyToOne
    @JsonIgnoreProperties("employee")
    Department department;
}
