package com.dio.santander.model.vo;

import com.dio.santander.entities.Department;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ProductVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2806421523585360625L;
    private Long id;
    private String name;
    private String price;
    private transient Department department;
}
