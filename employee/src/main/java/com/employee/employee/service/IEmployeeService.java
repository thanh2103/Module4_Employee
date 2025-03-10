package com.employee.employee.service;

import com.employee.employee.dto.EmployeeSearchRequest;
import com.employee.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findByNameContaining(String name, Pageable pageable);

    Page<Employee> findByAttribute(EmployeeSearchRequest employeeSearchRequest, Pageable pageable);

    Optional<Employee> findById(Integer id);

    Employee save(Employee employee);

    void delete(Integer id);
}
