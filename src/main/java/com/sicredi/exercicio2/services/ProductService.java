package com.sicredi.exercicio2.services;


import com.sicredi.exercicio2.entities.Product;
import com.sicredi.exercicio2.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public void delProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product editProduct(Long id, Product product){
        Product productEdit = validated(id);
        BeanUtils.copyProperties(product,productEdit,"id");

        return productRepository.save(productEdit);

    }

    private Product validated (Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new EmptyResultDataAccessException(1);

        return product.get();
    }


}
