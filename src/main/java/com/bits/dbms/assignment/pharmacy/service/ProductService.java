package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Product;
import com.bits.dbms.assignment.pharmacy.entity.Supplier;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    Product findProductById(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    void deleteProductById(Long id);

    List<Product> searchByName(String nameStr);

    void saveProductOffer(List<Product> products);

}
