package com.dio.santander.model.mapper;

import com.dio.santander.entities.Department;
import com.dio.santander.model.dto.DepartmentResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class DepartmentResponseMapper {

    private final DepartmentResponseDTO responseDTO = new DepartmentResponseDTO();

    public DepartmentResponseMapper(List<Department> list){

        List<Department> content = new ArrayList<>();

        for (Department department : list){

            Department dp = new Department();
            dp.setId(department.getId());
            dp.setName(department.getName());

            content.add(dp);
        }
        responseDTO.setContent(content);
        responseDTO.setValuesPageable(content);
    }

    public DepartmentResponseDTO getResponseDTO() {
        return responseDTO;
    }
}
