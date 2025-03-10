package com.employee.employee.service;

import com.employee.employee.model.Department;
import com.employee.employee.repository.IDepartmentReponsitory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentService implements IDepartmentService {

    IDepartmentReponsitory iDepartmentReponsitory;

    @Override
    public List<Department> getAllDepartments() {
        return iDepartmentReponsitory.findAll();
    }

    @Override
    public List<Department> findByDepartment_nameContaining(String department_name) {
        return iDepartmentReponsitory.findByNameContaining(department_name);
    }


    @Override
    public Optional<Department> findById(Integer departmentId) {
        return iDepartmentReponsitory.findById(departmentId);
    }

    @Override
    public Department save(Department department) {
        return iDepartmentReponsitory.save(department);
    }

    @Override
    public void delete(Integer departmentId) {
        iDepartmentReponsitory.deleteById(departmentId);
    }
}
