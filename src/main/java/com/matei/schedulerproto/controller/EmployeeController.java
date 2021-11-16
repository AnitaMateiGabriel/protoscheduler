package com.matei.schedulerproto.controller;

import com.matei.schedulerproto.model.entity.Employee;
import com.matei.schedulerproto.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/employees/")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable Long id){
        return new ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.FOUND);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.created(URI.create("api/employees/"+createdEmployee.getId())).body(createdEmployee);
    }

}
