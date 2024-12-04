package com.ERP.EmployeeManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.ERP.EmployeeManagement.model.modelEmployee;
import com.ERP.EmployeeManagement.service.serviceEmployee;

@RestController
@RequestMapping("/api/modelEmployee")
public class controllerEmployee {

    @Autowired
    private serviceEmployee serviceEmployee;

    @PostMapping
    public ResponseEntity<modelEmployee> createEmployee(@RequestBody modelEmployee employee) {
        modelEmployee savedEmployee = serviceEmployee.create(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping
    public List<modelEmployee> getAllEmployees() {
        return serviceEmployee.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<modelEmployee> getEmployeeById(@PathVariable Long id) {
        modelEmployee employee = serviceEmployee.getById(id);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        serviceEmployee.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id, @RequestBody modelEmployee employee) {
        serviceEmployee.update(id, employee);
        return ResponseEntity.noContent().build();
    }
}
