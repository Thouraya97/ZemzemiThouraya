package com.example.zemzemithouraya.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description ;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate ;

    @ManyToOne
    private Project project ;

}
