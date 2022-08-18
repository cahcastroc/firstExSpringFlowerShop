package com.sicredi.exercicio2.services;


import com.sicredi.exercicio2.model.Supplier;
import com.sicredi.exercicio2.repositories.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }

    public Supplier add(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public void delete (Long id){
        supplierRepository.deleteById(id);
    }

    public Supplier editSupplier(Long id, Supplier supplier){
        Supplier supplierEdit = validated(id);

        BeanUtils.copyProperties(supplier,supplierEdit,"id");

        return  supplierRepository.save(supplierEdit);

    }

    public Supplier validated (Long id){
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if(supplier.isEmpty())
            throw new EmptyResultDataAccessException(1);

        return supplier.get();

    }
}
