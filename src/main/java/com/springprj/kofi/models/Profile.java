package com.springprj.kofi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nickname ;

    @Column
    private String description;


    @Column(nullable = true)
    private String avatar;

    @ManyToMany
    @JoinTable(
            name = "profile_follow",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"))
    Set<User> follows;

    @ManyToOne
    @JoinColumn(name="category", nullable=false)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "profile")
    private List<Post> posts;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "profile")
    private List<Gallery> galleries;

}
