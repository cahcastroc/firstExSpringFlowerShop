package com.sicredi.exercicio2.entities;


import com.sicredi.exercicio2.exceptions.Constants;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message= "Nome " + Constants.OBRIGATORIO)
    @Length (min=3, max= 20, message = Constants.OBRIGATORIO)
    private String name;
    private TypeEnum type;
    private String family;
    private String purchaseYear;
    private String expirationDate;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
     private Supplier supplier;

    public Product() {
    }

    public Product(Long id, String name, TypeEnum type, String family, String purchaseYear, String expirationDate, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.family = family;
        this.purchaseYear = purchaseYear;
        this.expirationDate = expirationDate;
        this.supplier = supplier;
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

    public TypeEnum getType() {

        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(String purchaseYear) {
        this.purchaseYear = purchaseYear;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


}
