package com.employee.employee.service;

import com.employee.employee.dto.EmployeeSearchRequest;
import com.employee.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> findByNameContaining(String name);
    public List<Employee> findByAttribute(EmployeeSearchRequest employeeSearchRequest);
Optional<Employee> findById(Integer id);
Employee save(Employee employee);
void delete(Integer id);
}
