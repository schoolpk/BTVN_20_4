package com.tn;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Entity
@Table(name = "crudaccount")
public class CrudAccount {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer id;

    private String fullName;

    private String username;

    private String password;

    private String  email;
}
