package com.jpa_demo.controllers;

import com.jpa_demo.entities.Address;
import com.jpa_demo.entities.Employee;
import com.jpa_demo.model.EmployeeModel;
import com.jpa_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/emp/")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<?> saveDate(@RequestBody EmployeeModel empModel){
        Map<String,Object> model =new HashMap<String,Object>();
        //Creating Employee object and setting properties
        Employee emp =new Employee();
        emp.setName(empModel.getName());
        emp.setEmailId(empModel.getEmailId());
        emp.setMobileNo(empModel.getMobileNo());
        emp.setDesignation(empModel.getDesignation());

        //Creating Address object and setting properties
        Address add =new Address();
        add.setStreet(empModel.getStreet());
        add.setCity(empModel.getCity());
        add.setState(empModel.getState());
        emp.setAddress(add);
        employeeService.saveEmployee(emp);
        model.put("status",1);
        model.put("message","Record is Saved Successfully!");
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getEmps(){
        Map<String,Object> model =new HashMap<String,Object>();
        List<Employee> data =employeeService.getEmployees();
        if(!data.isEmpty()){
            model.put("status",1);
            model.put("data",data);

            return new ResponseEntity<>(model,HttpStatus.OK);
        }else{
            model.put("status",0);
            model.put("message","Data is not found");

            return new ResponseEntity<>(model,HttpStatus.NOT_FOUND);
        }
    }
}
