package com.employee.employee.Controller;

import com.employee.employee.dto.ApiResponsi;
import com.employee.employee.dto.EmployeeSearchRequest;
import com.employee.employee.dto.page.PageResponse;
import com.employee.employee.exception.ApiException;
import com.employee.employee.exception.ErrorCode;
import com.employee.employee.model.Employee;
import com.employee.employee.service.IEmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Scope("singleton")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeController {

    IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getEmployees(EmployeeSearchRequest employeeSearchRequest, Pageable pageable) {
        return ResponseEntity.ok(new PageResponse<>( employeeService.findByAttribute(employeeSearchRequest,pageable)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return employeeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST));
    }


    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.findById(id).orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST));
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
