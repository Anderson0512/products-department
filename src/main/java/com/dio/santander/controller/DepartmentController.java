package com.dio.santander.controller;

import com.dio.santander.entities.Department;
import com.dio.santander.model.dto.DepartmentResponseDTO;
import com.dio.santander.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

  private final DepartmentService departmentService;

  @Autowired
  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping
  public DepartmentResponseDTO getDepartment() {
    return departmentService.getDepartments();
  }

  @PostMapping
  public ResponseEntity<Department> save(@RequestBody Department department) {
    var depCreate = departmentService.create(department);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(depCreate.getId()).toUri();
    return ResponseEntity.created(uri).body(depCreate);
  }

  @GetMapping("/{id}")
  public Department getById(@PathVariable Long id) {
    return departmentService.getById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Department putById(@PathVariable Long id, @RequestParam String name) {
    return departmentService.putById(id, name);
  }

  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable Long id) {
    departmentService.deleteById(id);
    return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("Dados apagados do id " + id).getBody();
  }
}
