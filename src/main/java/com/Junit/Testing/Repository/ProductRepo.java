package com.Junit.Testing.Repository;

import com.Junit.Testing.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

 public  List<Product> findBynameContaining(String name);

}
