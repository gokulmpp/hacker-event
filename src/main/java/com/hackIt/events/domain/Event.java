package com.hackIt.events.domain;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "event")
public class Event {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String organizer;

    @OneToMany(mappedBy = "event")
    private List<Team> teams;
    public Event(){}

    public Event(String id,String name,String organizer){
        this.id=id;
        this.name=name;
        this.organizer=organizer;
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

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
