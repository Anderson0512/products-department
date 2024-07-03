package com.dio.santander.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_product")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Product(Long id,Department department, String name, Double price) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.price = price;
    }
}
