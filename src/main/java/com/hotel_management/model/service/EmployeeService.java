package com.hotel_management.model.service;

import com.hotel_management.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeId(long eid);
}
