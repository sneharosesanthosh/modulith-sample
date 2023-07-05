package com.sneha.monolith.department.internal;

import com.sneha.monolith.employee.internal.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    @Repository
    public static class DepartmentRepository {


        private List<Department> departments = new ArrayList<>();

        public Department addDepartment(Department department) {
            departments.add(department);
            return department;
        }

        public Department findById(Long id) {
            return departments.stream()
                    .filter(department -> department.getId().equals(id))
                    .findFirst()
                    .orElseThrow();
        }

        public List<Department> findAll() {
            return departments;
        }

    }
}
