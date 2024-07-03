package com.dio.santander.model.mapper;

import com.dio.santander.entities.Product;
import com.dio.santander.model.vo.ProductVO;

public class ProductResponseMapper {
    private final ProductVO productVO = new ProductVO();

    public ProductResponseMapper(Product product){
        productVO.setId(product.getId());
        productVO.setName(product.getName());
        productVO.setPrice("R$ " + String.format("%.2f", product.getPrice()));
        productVO.setDepartment(product.getDepartment());
    }
    public ProductVO getProductVO(){
        return productVO;
    }
}
