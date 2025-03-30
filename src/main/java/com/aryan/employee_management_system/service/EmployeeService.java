package com.aryan.employee_management_system.service;


import com.aryan.employee_management_system.entity.Employee;
import com.aryan.employee_management_system.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("/getEmployeeByName/{name}")
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee removed !! " + id;
    }

}
