package com.springprj.kofi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class Post extends Dest {
    @ManyToOne
    @JoinColumn(name="profile_id", nullable=false)
    private Profile profile;
}
