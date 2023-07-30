package com.pe.employeesystem.controller;

import com.pe.employeesystem.entity.EmployeeEntity;
import com.pe.employeesystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employees = employeeService.findAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeEntity employee = employeeService.findEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
