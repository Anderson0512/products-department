package com.dio.santander.model.mapper;

import com.dio.santander.entities.Product;
import com.dio.santander.model.dto.ProductListDTO;
import com.dio.santander.model.vo.ProductVO;

import java.util.ArrayList;
import java.util.List;

public class ProductListResponseMapper {

    private final ProductListDTO productListDTO = new ProductListDTO();

    public ProductListResponseMapper(List<Product> list){

        List<ProductVO> productVOList = new ArrayList<>();

        for (Product product : list){
            ProductVO productVO = new ProductVO();
            productVO.setId(product.getId());
            productVO.setName(product.getName());
            productVO.setPrice("R$ ".concat(String.format("%.2f", product.getPrice())));
            productVO.setDepartment(product.getDepartment());
            productVOList.add(productVO);
        }
        productListDTO.setProductVOList(productVOList);
        productListDTO.setValuesPageable(productVOList);
    }

    public ProductListDTO getProductListDTO() {
        return productListDTO;
    }
}
