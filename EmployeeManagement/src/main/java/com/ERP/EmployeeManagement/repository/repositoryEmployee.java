package com.ERP.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ERP.EmployeeManagement.model.modelEmployee;

@Repository
public interface repositoryEmployee extends JpaRepository<modelEmployee, Long> {

}
