package com.sicredi.exercicio2.controllers;

import com.sicredi.exercicio2.entities.Product;
import com.sicredi.exercicio2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = productService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
        Product productAdd = productService.addProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productAdd);

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct (@RequestBody Product product){
        productService.delProduct(product.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@Valid @PathVariable Long id, @RequestBody Product product){
        return ResponseEntity.ok(productService.editProduct(id,product));
    }

}
