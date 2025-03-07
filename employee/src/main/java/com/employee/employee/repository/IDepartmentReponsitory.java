package com.employee.employee.repository;

import com.employee.employee.model.Department;
import com.employee.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartmentReponsitory extends JpaRepository<Department, Integer> {
    @Query(value = """
        SELECT d.* FROM department d
        WHERE (:department_name IS NULL OR d.name LIKE CONCAT('%', :department_name, '%'))
        """, nativeQuery = true)
    List<Department> findByAttributes(@Param("department_name") String department_name);
}
