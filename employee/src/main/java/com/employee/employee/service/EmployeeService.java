package com.employee.employee.service;

import com.employee.employee.dto.EmployeeSearchRequest;
import com.employee.employee.dto.page.PageCustom;
import com.employee.employee.model.Employee;
import com.employee.employee.repository.EmployeeSpecification;
import com.employee.employee.repository.IEmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository;



    @Override
    public Page<Employee> findByNameContaining(String name, org.springframework.data.domain.Pageable pageable) {
        return employeeRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Employee> findByAttribute(EmployeeSearchRequest employeeSearchRequest, org.springframework.data.domain.Pageable pageable) {
        Specification<Employee> specification = Specification.where(EmployeeSpecification.hasName(employeeSearchRequest.getName()))
                .and(EmployeeSpecification.hasDobFrom(employeeSearchRequest.getDobFrom()))
                .and(EmployeeSpecification.hasDobTo(employeeSearchRequest.getDobTo()))
                .and(EmployeeSpecification.hasGender(employeeSearchRequest.getGender()))
                .and(EmployeeSpecification.hasDepartmentId(employeeSearchRequest.getDepartmentId()))
                .and(EmployeeSpecification.hasSalaryInRange(employeeSearchRequest.getSalaryRange()));

        return employeeRepository.findAll(specification,pageable);
    }

    @Override
    public Optional<Employee> findById(Integer id){
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }


}
