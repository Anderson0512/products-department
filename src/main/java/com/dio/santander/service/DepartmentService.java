package com.dio.santander.service;

import com.dio.santander.entities.Department;
import com.dio.santander.exception.BussinessException;
import com.dio.santander.model.dto.DepartmentResponseDTO;

public interface DepartmentService {
    DepartmentResponseDTO getDepartments() throws BussinessException;
    Department create(Department name) throws BussinessException;
    Department getById(Long id) throws BussinessException;
    Department putById(Long id, String name) throws BussinessException;
    void deleteById(Long id) throws BussinessException;
}
