package com.employee.employee.service;

import com.employee.employee.model.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    List<Department> getAllDepartments();

    List<Department> findByDepartment_nameContaining(String department_name);


    Optional<Department> findById(Integer departmentId);

    Department save(Department department);

    void delete(Integer departmentId);
}
