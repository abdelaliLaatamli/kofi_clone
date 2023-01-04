package com.springprj.kofi.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name="dest_id", nullable=false)
    private Dest Dest;
}
