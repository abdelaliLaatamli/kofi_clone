package com.springprj.kofi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data  @Builder  @NoArgsConstructor @AllArgsConstructor
@Entity
public class Gallery extends Dest {

    @Column
    private String image;


    @ManyToOne
    @JoinColumn(name="profile_id", nullable=false)
    private Profile profile;
}
