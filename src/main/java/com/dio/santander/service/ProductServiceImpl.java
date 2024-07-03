package com.dio.santander.service;

import com.dio.santander.entities.Department;
import com.dio.santander.entities.Product;
import com.dio.santander.exception.BussinessException;
import com.dio.santander.model.dto.ProductListDTO;
import com.dio.santander.model.dto.ProductRequestDTO;
import com.dio.santander.model.mapper.ProductListResponseMapper;
import com.dio.santander.model.mapper.ProductRequestMapper;
import com.dio.santander.model.mapper.ProductRequestUpdateMapper;
import com.dio.santander.model.mapper.ProductResponseMapper;
import com.dio.santander.model.vo.ProductVO;
import com.dio.santander.repository.DepartmentRepository;
import com.dio.santander.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final DepartmentRepository departmentRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository, DepartmentRepository departmentRepository) {
    this.productRepository = productRepository;
    this.departmentRepository = departmentRepository;
  }

  @Override
  public ProductVO saveProduct(ProductRequestDTO requestDTO) throws BussinessException {

    try {
      Department dp = departmentRepository.findById(requestDTO.getDepartment()).orElseThrow();
      Product p2 = productRepository.save(new ProductRequestMapper(requestDTO, dp).getProduct());
      return new ProductResponseMapper(p2).getProductVO();
    } catch (RuntimeException e) {
      throw new BussinessException("Error create product. ".concat(e.getMessage()), e);
    }
  }

  @Override
  public ProductVO updateProduct(Long id, ProductRequestDTO requestDTO) throws BussinessException {

    try {
      var dp = departmentRepository.findById(requestDTO.getDepartment()).orElseThrow();
      var upProduct = productRepository.findById(id).orElseThrow();
      var product = new ProductRequestUpdateMapper().getProduct(requestDTO, dp, upProduct);
      return new ProductResponseMapper(productRepository.save(product)).getProductVO();
    } catch (RuntimeException e) {
      throw new BussinessException("Error update product id ".concat(String.valueOf(id)).concat(e.getMessage()), e);
    }
  }

  @Override
  public ProductListDTO getListProduct() throws BussinessException {
    try {

      List<Product> list = productRepository.findAll();
      return new ProductListResponseMapper(list).getProductListDTO();
    } catch (RuntimeException e) {
      throw new BussinessException("Error find all products. ".concat(e.getMessage()), e);
    }
  }

  @Override
  public ProductVO getProduct(Long id) throws BussinessException {

    try {
      Product product = productRepository.findById(id).orElseThrow();
      return new ProductResponseMapper(product).getProductVO();
    } catch (RuntimeException e) {
      throw new BussinessException("Error find product by id ".concat(String.valueOf(id)).concat(e.getMessage()), e);
    }
  }

  @Override
  public void deleteById(Long id) throws BussinessException {

    try {
      var product = productRepository.findById(id).orElseThrow();
      productRepository.delete(product);
    } catch (RuntimeException e) {
      throw new BussinessException("Error delete product by id ".concat(String.valueOf(id)).concat(e.getMessage()), e);
    }
  }
}
