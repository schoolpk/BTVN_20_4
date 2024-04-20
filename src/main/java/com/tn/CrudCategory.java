package com.tn;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "crudcategory")
public class CrudCategory {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer id;

    private String categoryName;

}
