package com.sneha.monolith.department;

import com.sneha.monolith.department.internal.Department;
import com.sneha.monolith.employee.EmployeeController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {

    private final Department.DepartmentRepository departmentRepository;
    private final EmployeeController employeeRepository;

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        log.info("CONTROL addDepartment: " + department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        log.info("CONTROL findAll: ");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        log.info("CONTROL findById: ");
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        log.info("Inside findAllWithEmployees---->");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> {
            department.setEmployees(employeeRepository.getEmployeesByDepartment(department.getId()));
        });
        return departments;
    }

}
