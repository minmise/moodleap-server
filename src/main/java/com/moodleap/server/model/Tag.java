package com.moodleap.server.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany(mappedBy = "tags")
    private Set<Mood> moods = new HashSet<>();

    public Tag() {}

    public Tag(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Set<Mood> getMoods() {
        return moods;
    }

}
