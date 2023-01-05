package com.springprj.kofi.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Data
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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> commants;

}

