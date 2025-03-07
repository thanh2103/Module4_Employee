package com.employee.employee.dto;

import com.employee.employee.model.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class EmployeeSearchRequest {
    String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dobFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dobTo;

    Employee.Gender gender;

    String salaryRange;

    String phone;

    Integer departmentId;
}
