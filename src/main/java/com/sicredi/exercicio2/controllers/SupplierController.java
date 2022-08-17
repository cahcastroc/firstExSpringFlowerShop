package com.sicredi.exercicio2.controllers;


import com.sicredi.exercicio2.entities.Product;
import com.sicredi.exercicio2.entities.Supplier;
import com.sicredi.exercicio2.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> findAll(){
        List <Supplier> list = supplierService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@Valid @RequestBody Supplier supplier){
        Supplier supplierAdd = supplierService.add(supplier);

        return ResponseEntity.status(HttpStatus.CREATED).body(supplierAdd);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSupplier (@RequestBody Supplier supplier){
        supplierService.delete(supplier.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> editProduct(@Valid @PathVariable Long id, @RequestBody Supplier supplier){
        return ResponseEntity.ok(supplierService.editSupplier(id, supplier));
    }

}
