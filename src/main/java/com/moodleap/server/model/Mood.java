package com.moodleap.server.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "moods")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Long emotion;
    private Long timestamp;

    @ManyToMany
    @JoinTable(
            name = "mood_tags",
            joinColumns = @JoinColumn(name = "mood_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    public Mood() {}

    public Mood(Long emotion, Long timestamp) {
        this.emotion = emotion;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Long getEmotion() {
        return emotion;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Set<Tag> getTags() {
        return tags;
    }

}
