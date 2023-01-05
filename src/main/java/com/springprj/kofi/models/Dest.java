package com.springprj.kofi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


    //@OneToMany(mappedBy="Dest" )
    //private List<Comment> commands;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> commants;

}

