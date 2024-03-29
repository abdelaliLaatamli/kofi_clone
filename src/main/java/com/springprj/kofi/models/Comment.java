package com.springprj.kofi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String comment;

    // @ManyToOne
    // @JoinColumn(name="dest_id", nullable=false)
    // private Dest Dest;
}
