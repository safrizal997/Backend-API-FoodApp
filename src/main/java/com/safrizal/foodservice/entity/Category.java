package com.safrizal.foodservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "uniqueNameConstraint")})
public class Category {

    @Id
    private String id;
    private String name;
    private String description;

}
