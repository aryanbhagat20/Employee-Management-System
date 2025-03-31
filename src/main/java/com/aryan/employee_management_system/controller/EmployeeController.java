package com.aryan.employee_management_system.controller;

import com.aryan.employee_management_system.entity.Employee;
import com.aryan.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> employees(@RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getEmployeeByName/{name}")
    public Employee getEmployeeByName(@PathVariable String firstName){
        return employeeService.getEmployeeByName(firstName);
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        return employeeService.saveEmployee(existingEmployee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
