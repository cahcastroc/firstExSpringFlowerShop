package com.sicredi.exercicio2.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier implements Serializable {

    private static final long serialVersionUID=2L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cnpj;

    @OneToMany
    private List<Product> products = new ArrayList();

    public Supplier() {
    }

    public Supplier(Long id, String name, String cnpj, List<Product> products) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Product> getProducts() {
        return products;
    }
}
