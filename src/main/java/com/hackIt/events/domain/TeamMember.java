package com.hackIt.events.domain;

import jakarta.persistence.*;

@Entity
@Table(name="team_member")
public class TeamMember {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team teams;

    public TeamMember(){}

    public TeamMember(String id, String name, String email, Team teams){
        this.id=id;
        this.name=name;
        this.email=email;
        this.teams=teams;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeams() {
        return teams;
    }

    public void setTeams(Team teams) {
        this.teams = teams;
    }
}
