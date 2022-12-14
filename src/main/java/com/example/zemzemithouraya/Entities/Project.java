package com.example.zemzemithouraya.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title ;
    private String description ;


    @ManyToOne
    private User user ;
    @ManyToMany
    private List<User> users ;

    @OneToMany(mappedBy = "project")
    private List<Sprint> sprints ;

}
