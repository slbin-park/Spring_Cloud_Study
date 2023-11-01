package com.example.catalogservice.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name= "catalog")
public class CatalogEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;

    @CreationTimestamp
    private Date createdAt;

}
