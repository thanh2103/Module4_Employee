package com.employee.employee.Controller;


import com.employee.employee.exception.ApiException;
import com.employee.employee.exception.ErrorCode;
import com.employee.employee.model.Department;
import com.employee.employee.service.IDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/departments")
public class DepartmentController {
    IDepartmentService iDepartmentService;

    @GetMapping
    public ResponseEntity<?> getDepartments(String name) {
        return ResponseEntity.ok(iDepartmentService.findByDepartment_nameContaining(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        return iDepartmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ApiException(ErrorCode.DEPARTMENT_NOT_EXIST));
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iDepartmentService.save(department));
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("departmentId") int departmentId, @RequestBody Department department) {
        iDepartmentService.findById(departmentId).orElseThrow(() -> new ApiException(ErrorCode.DEPARTMENT_NOT_EXIST));
        department.setDepartment_id(departmentId);
        return ResponseEntity.ok(iDepartmentService.save(department));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("departmentId") int departmentId) {
        iDepartmentService.findById(departmentId).orElseThrow(() -> new ApiException(ErrorCode.DEPARTMENT_NOT_EXIST));
        iDepartmentService.delete(departmentId);
        return ResponseEntity.noContent().build();
    }
}
