package com.jpa_demo.service.serviceImpl;

import com.jpa_demo.entities.Employee;
import com.jpa_demo.repositories.EmployeeRepo;
import com.jpa_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }
}
