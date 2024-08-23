package com.Junit.Testing;

import com.Junit.Testing.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Product,Integer> {
}
