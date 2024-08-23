package com.Junit.Testing.Controller;

import com.Junit.Testing.Entity.Product;
import com.Junit.Testing.Exception.ProductNotFoundException;
import com.Junit.Testing.Service.ProductService;
import com.Junit.Testing.Service.ProductServiceimple;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productservice;

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product) throws NoSuchMethodException
    {
        return new ResponseEntity<Product> (productservice.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Product>> getAllCustomers()throws ProductNotFoundException
    {
        return new ResponseEntity<List<Product>> (productservice.fetchAllProducts(), HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{id}")
    public Product getCustomer(@PathVariable Long id) throws ProductNotFoundException {

        return productservice.fetchProduct(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> patchUpdateCustomer(@PathVariable Long id, @RequestBody Product product) {
        return new ResponseEntity<Product> (productservice.updateProduct(id, product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) throws ProductNotFoundException {
        return new ResponseEntity<String> (productservice.deleteProduct(id), HttpStatus.CREATED);
    }

    @GetMapping("/getproductByname/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name) throws ProductNotFoundException{
        return new ResponseEntity<>(productservice.fetchByProductName(name),HttpStatus.CREATED);
    }


}
