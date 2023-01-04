package com.springprj.kofi.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column(columnDefinition = "text")
    private String details;


    @OneToMany( targetEntity=Comment.class, mappedBy="dest" )
    private List<Comment> commands = new ArrayList<>();

}

