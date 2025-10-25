package com.hacker.events.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    private String id;
    private String teamName;
    private String teamLead;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMember> teamMembers = new ArrayList<>();

    public Team(){}

    public Team(String id,String teamName,String teamLead){
        this.id=id;
        this.teamName=teamName;
        this.teamLead=teamLead;
    }

    public String getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(TeamMember teamMember) {
        teamMembers.add(teamMember);
        teamMember.setTeam(this);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
