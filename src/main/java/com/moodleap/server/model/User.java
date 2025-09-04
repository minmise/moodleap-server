package com.moodleap.server.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String uid;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mood> moods = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        if (uid == null) {
            uid = UUID.randomUUID().toString();
        }
    }

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.uid = UUID.randomUUID().toString();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUid() {
        return uid;
    }

    public List<Mood> getMoods() {
        return moods;
    }

}
