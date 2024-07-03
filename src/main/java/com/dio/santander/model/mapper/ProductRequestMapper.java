package com.dio.santander.model.mapper;

import com.dio.santander.entities.Department;
import com.dio.santander.entities.Product;
import com.dio.santander.model.dto.ProductRequestDTO;

public class ProductRequestMapper {

    private final Product product = new Product();

    public ProductRequestMapper(ProductRequestDTO productRequestDTO, Department dp){

        Double price = Double.valueOf(productRequestDTO.getPrice().replace(',','.'));

        product.setName(productRequestDTO.getName());
        product.setPrice(price);
        product.setDepartment(dp);
    }

    public Product getProduct() {
        return product;
    }
}
