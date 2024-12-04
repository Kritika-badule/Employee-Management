package com.ERP.EmployeeManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ERP.EmployeeManagement.model.modelEmployee;
import com.ERP.EmployeeManagement.repository.repositoryEmployee;

// Define or import this custom exception
import org.springframework.web.server.ResponseStatusException; // Spring Web exception handling
import org.springframework.http.HttpStatus; // To return proper error status

@Service
public class serviceEmployee {

    @Autowired
    private repositoryEmployee repository;

    // Get all employees
    public List<modelEmployee> getAll() {
        return repository.findAll();
    }

    // Get employee by ID, throws exception if not found
    public modelEmployee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found for ID " + id));
    }

    // Create a new employee entry
    public modelEmployee create(modelEmployee employee) {
        return repository.save(employee);
    }

    // Update an existing employee entry by ID
    public modelEmployee update(Long id, modelEmployee employeeDetails) {
        modelEmployee existingEmployee = getById(id);

        // Updating employee details
        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setDepartment(employeeDetails.getDepartment());

        return repository.save(existingEmployee); // Save the updated employee
    }

    // Delete an employee by ID
    public void delete(Long id) {
        modelEmployee employee = getById(id); // Find employee by ID
        repository.delete(employee); // Delete employee
    }
}
