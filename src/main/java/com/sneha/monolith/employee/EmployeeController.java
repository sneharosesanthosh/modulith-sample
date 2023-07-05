package com.sneha.monolith.employee;

import com.sneha.monolith.employee.EmployeeRepository;
import com.sneha.monolith.employee.internal.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j

public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("CONTROL addDepartment: " + employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        log.info("CONTROL findAll: ");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        log.info("CONTROL findById: ");
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long departmentId) {
        log.info("CONTROL getEmployeesByDepartment: ");
        return employeeRepository.getByDepartment(departmentId);
    }

}
