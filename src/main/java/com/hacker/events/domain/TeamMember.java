package com.hacker.events.domain;

import jakarta.persistence.*;

@Entity
public class TeamMember {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public TeamMember() {}

    public TeamMember(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team teams) {
        this.team = teams;
    }
}
