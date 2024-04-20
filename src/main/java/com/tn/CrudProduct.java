package com.tn;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
@Entity
@Table(name = "crudproduct")
public class CrudProduct {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer id;

    private Integer price;

    private int so_luong;

    private String chat_luong;

    private String ten_sanpham;
}
