package com.dio.santander.controller;

import com.dio.santander.model.dto.ProductListDTO;
import com.dio.santander.model.dto.ProductRequestDTO;
import com.dio.santander.model.vo.ProductVO;
import com.dio.santander.service.ProductService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductVO> saveProduct(@RequestBody ProductRequestDTO requestDTO){
        var prodCreated = productService.saveProduct(requestDTO);
        URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(prodCreated.getId()).toUri();
        return ResponseEntity.created(uriLocation).body(prodCreated);
    }
    @GetMapping
    public ResponseEntity<ProductListDTO> getObjects() {
        var prod =  productService.getListProduct();
        if (CollectionUtils.isEmpty(prod.getProductVOList())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.OK).body(prod);
    }

    @GetMapping("/{id}")
    public ProductVO getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductVO update(@PathVariable Long id, @RequestBody ProductRequestDTO requestDTO){
        return productService.updateProduct(id,requestDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
     productService.deleteById(id);
     return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("Dados apagados do produto id " + id).getBody();
    }
}
