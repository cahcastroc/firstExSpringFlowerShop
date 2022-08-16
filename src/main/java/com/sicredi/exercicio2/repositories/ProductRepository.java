package com.sicredi.exercicio2.repositories;

import com.sicredi.exercicio2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
