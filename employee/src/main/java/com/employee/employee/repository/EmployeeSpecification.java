package com.employee.employee.repository;

import com.employee.employee.model.Employee;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeSpecification {
    public static Specification<Employee> hasName(String name) {
        return (root, query, criteriaBuilder) -> name == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Employee> hasDobFrom(LocalDate dobFrom) {
        return ((root, query, criteriaBuilder) -> dobFrom == null ? null :
                criteriaBuilder.greaterThanOrEqualTo(root.get("dob"), dobFrom));
    }
    public static Specification<Employee> hasDobTo(LocalDate dobTo) {
        return ((root, query, criteriaBuilder) -> dobTo == null ? null :
                criteriaBuilder.lessThanOrEqualTo(root.get("dob"), dobTo));
    }

    public static Specification<Employee> hasGender(Employee.Gender gender) {
        return ((root, query, criteriaBuilder) -> gender == null ? null :
                criteriaBuilder.equal(root.get("gender"), gender));
    }

    public static Specification<Employee> hasDepartmentId(Integer departmentId) {
        return (root, query, cb) ->
                (departmentId == null) ? null
                        : cb.equal(root.join("department", JoinType.LEFT).get("id"), departmentId);
    }
    public static Specification<Employee> hasSalaryInRange(String salaryRange) {
        return (root, query, cb) -> {
            if (salaryRange == null) return null;

            BigDecimal fiveMillion = new BigDecimal("5000000");
            BigDecimal tenMillion = new BigDecimal("10000000");
            BigDecimal twentyMillion = new BigDecimal("20000000");

            return switch (salaryRange) {
                case "lt5" -> cb.lessThan(root.get("salary"), fiveMillion);
                case "5-10" -> cb.between(root.get("salary"), fiveMillion, tenMillion);
                case "10-20" -> cb.between(root.get("salary"), tenMillion, twentyMillion);
                case "gt20" -> cb.greaterThan(root.get("salary"), twentyMillion);
                default -> null;
            };
        };
    }

}
