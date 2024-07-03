# Santander Dev Week 2024
Java RESTful Api criada Bootcamp Santander

## Diagrama de Classe

```mermaid
classDiagram
  class Product {
    <<DTO>>
    -int id
    -String name
    -String price
    -Department department
  }
  
  class Department {
    <<DTO>>
    -int id
    -String name
  }
  
  Product --> Department : department
```
