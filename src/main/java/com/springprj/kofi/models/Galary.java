package com.springprj.kofi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data  @Builder  @NoArgsConstructor @AllArgsConstructor
@Entity
public class Galary extends Dest {

    @Column
    private String image;
}
