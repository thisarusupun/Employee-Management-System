package com.thisaruspun.employeesystemapi.services;

import com.thisaruspun.employeesystemapi.entity.Employee;
import com.thisaruspun.employeesystemapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    // create employee
    @Override
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    // get all employee
    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // delete existing employee
    @Override
    public Employee deleteEmployee(Long id){
        Employee deletedEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("User Not Found"));
        employeeRepository.deleteById(id);
        return deletedEmployee;
    }

    // get specific employee
    @Override
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("User Not Found"));
    }

    // update employee details
    @Override
    public Employee updateEmployee(Long id, Employee employee){

        Employee updatingEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("User Not Found"));

        updatingEmployee.setFirstName(employee.getFirstName());
        updatingEmployee.setLastName(employee.getLastName());
        updatingEmployee.setEmailId(employee.getEmailId());
        employeeRepository.save(updatingEmployee);

        return employee;
    }
}
