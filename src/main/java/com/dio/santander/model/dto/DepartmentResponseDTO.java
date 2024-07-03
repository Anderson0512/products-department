package com.dio.santander.model.dto;

import com.dio.santander.entities.Department;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class DepartmentResponseDTO extends BaseListBFFResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("_content")
    private transient List<Department> content;
}
