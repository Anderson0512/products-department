package com.dio.santander.service;

import com.dio.santander.exception.BussinessException;
import com.dio.santander.model.dto.ProductListDTO;
import com.dio.santander.model.dto.ProductRequestDTO;
import com.dio.santander.model.vo.ProductVO;

public interface ProductService {

    ProductVO saveProduct(ProductRequestDTO requestDTO) throws BussinessException;
    ProductVO updateProduct(Long id, ProductRequestDTO requestDTO) throws BussinessException;
    ProductListDTO getListProduct() throws BussinessException;
    ProductVO getProduct(Long id) throws BussinessException;
    void deleteById(Long id) throws BussinessException;

}
