package com.safrizal.foodservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_food", indexes = @Index(columnList = "name"))
public class Food {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn
    private Category category;
    private int stock;
    private String description;
    private String tags;
    private byte isDelete;
    private Date createdDate;
    private Date modifiedDate;

}
