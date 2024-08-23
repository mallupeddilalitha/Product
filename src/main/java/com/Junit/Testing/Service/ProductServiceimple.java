package com.Junit.Testing.Service;

import com.Junit.Testing.Entity.Product;
import com.Junit.Testing.Exception.ProductNotFoundException;
import com.Junit.Testing.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceimple implements  ProductService {


    @Autowired
    private ProductRepo productrepository;
    boolean flag;


    @Override
    public Product saveProduct(Product product) {
        return productrepository.save(product);
    }

    @Override
    public List<Product> fetchAllProducts() {
        return productrepository.findAll();
    }



    @Override
    public Product fetchProduct(Long id) throws ProductNotFoundException {
        Optional<Product> product = productrepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
    }

    /* @Override
    public Product fetchProduct(Long id) {
        if (id != null && id != 0) {
            flag = productrepository.existsById(id);
        }
        if (flag)
            return productrepository.findById(id).get();
        else
            return null;
    }*/

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productrepository.findById(id).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDepartment(product.getDepartment());
        return productrepository.save(existingProduct);
    }

    @Override
    public String deleteProduct(Long id) {
         if (id == null || id == 0) {
            return "Invalid product ID";
        }

        boolean flag = productrepository.existsById(id);

        if (flag) {
            productrepository.deleteById(id);
            return "Product deleted successfully";
        } else {
            return "Product not found";
        }
    }


    @Override
    public List<Product> fetchByProductName(String name) throws ProductNotFoundException {
        return  productrepository.findBynameContaining(name);

    }




//    @Override
//    public List<Product> fetchByProductName(String name) throws ProductNotFoundException {
//        List<Product> pdtlist = productrepository.findBynameContaining(name);
//        if (pdtlist.isEmpty())
//            throw new ProductNotFoundException("No tickets found with this status containing: " + name);
//        else {
//            return pdtlist;
//        }
//    }



//    public ResponseEntity<String> deleteProductById(Integer id) throws ProductNotFoundException {
//        Optional<Product> opproduct = productrepository.findById(id);
//        if (opproduct.isPresent()) {
//            productrepository.deleteById(id);
//            Optional<Product> optionalticket = productrepository.findById(id);
//            if (optionalticket.isEmpty())
//                return new ResponseEntity<String>("Deleted successfully!!", HttpStatus.OK);
//        } else
//            throw new ProductNotFoundException("No ticket found with this id: " + id);
//        return null;
//    }
}
