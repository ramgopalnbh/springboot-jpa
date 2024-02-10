package com.jpa_demo.service;

import com.jpa_demo.entities.Employee;
import com.jpa_demo.repositories.EmployeeRepo;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    List<Employee> getEmployees();
}
