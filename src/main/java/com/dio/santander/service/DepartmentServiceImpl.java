package com.dio.santander.service;

import com.dio.santander.entities.Department;
import com.dio.santander.exception.BussinessException;
import com.dio.santander.model.dto.DepartmentResponseDTO;
import com.dio.santander.model.mapper.DepartmentResponseMapper;
import com.dio.santander.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  @Autowired
  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public DepartmentResponseDTO getDepartments() throws BussinessException {

    try {

      return new DepartmentResponseMapper(departmentRepository.findAll()).getResponseDTO();
    } catch (RuntimeException e) {
      throw new BussinessException("Error find all departments. ".concat(e.getMessage()), e);
    }
  }

  @Override
  public Department create(Department name) throws BussinessException {

    try {
      return departmentRepository.save(name);
    } catch (RuntimeException e) {
      throw new BussinessException("Error create department. ".concat(e.getMessage()), e);
    }
  }

  @Override
  public Department getById(Long id) throws BussinessException {

    try {
      return departmentRepository.findById(id).orElseThrow();
    } catch (RuntimeException e) {
      throw new BussinessException("Error find id department. ".concat(e.getMessage()), e);
    }
  }

  @Override
  public Department putById(Long id, String name) throws BussinessException {
    try {
      Department dp = departmentRepository.findById(id).orElseThrow();
      dp.setName(name);
      return departmentRepository.save(dp);
    } catch (RuntimeException e) {
      throw new BussinessException("Error update department. ".concat(e.getMessage()), e);
    }
  }

  @Override
  public void deleteById(Long id) throws BussinessException {

    try {
      departmentRepository.delete(departmentRepository.findById(id).orElseThrow());
    } catch (RuntimeException e) {
      throw new BussinessException("Error department by id. ".concat(e.getMessage()), e);
    }
  }
}
