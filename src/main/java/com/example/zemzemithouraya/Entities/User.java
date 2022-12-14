package com.example.zemzemithouraya.Entities;

import com.example.zemzemithouraya.Enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email ;
    private String password ;
    private  String fName;
    private String lName ;
    @Enumerated(EnumType.STRING)
    private Role role ;

    @OneToMany(mappedBy = "user")
    private List<Project> projets ;

    @ManyToMany(mappedBy = "users")
    private List<Project> projects ;
}
