package com.aryan.employee_management_system.repository;

import com.aryan.employee_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);
}
