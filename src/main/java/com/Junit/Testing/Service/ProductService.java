package com.Junit.Testing.Service;

import com.Junit.Testing.Entity.Product;
import com.Junit.Testing.Exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

        public Product saveProduct(Product product);
        public List<Product> fetchAllProducts();
        public Product fetchProduct(Long id) throws ProductNotFoundException;
        public Product updateProduct(Long id, Product product);
        public String deleteProduct(Long id) throws ProductNotFoundException;

        public  List<Product>  fetchByProductName(String name) throws ProductNotFoundException;
}
