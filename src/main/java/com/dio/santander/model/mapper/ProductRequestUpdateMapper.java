package com.dio.santander.model.mapper;

import com.dio.santander.entities.Department;
import com.dio.santander.entities.Product;
import com.dio.santander.model.dto.ProductRequestDTO;

public class ProductRequestUpdateMapper {

    public ProductRequestUpdateMapper(){}
    public Product getProduct(ProductRequestDTO requestDTO, Department department, Product upProduct) {
        var price = Double.valueOf(requestDTO.getPrice().replace(',','.'));

        upProduct.setName(requestDTO.getName());
        upProduct.setPrice(price);
        upProduct.setDepartment(department);
        return upProduct;
    }
}
