package com.pe.employeesystem.service;

import com.pe.employeesystem.entity.EmployeeEntity;
import com.pe.employeesystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<EmployeeEntity> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity findEmployeeById(Long id) {
        return employeeRepository.findEmployeeEntityById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee" +
                " by id " + id + " was not found"));
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
