package com.Junit.Testing.Entity;

import com.Junit.Testing.Validations.PositivePrice;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    @NotNull(message =Message.msg)
    private String name;

    @PositivePrice
    private float price;

    @NotBlank
    @NotNull(message =Message.msg)
    private String department;


    public Product(String name, float price, String department) {
        super();
            this.name = name;
            this.price = price;
            this.department = department;

    }
}
