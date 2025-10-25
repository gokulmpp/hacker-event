package com.hackIt.events.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    private String id;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "team_lead")
    private String teamLead;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id",nullable = true)
    private Event event;

    @OneToMany(mappedBy = "teams")
    private List<TeamMember> teamMembers;

    public Team(){}
  /*  public Team(String id,String teamName,String teamLead,Event event){
        this.id=id;
        this.teamName=teamName;
        this.teamLead=teamLead;
        this.event=event;
    }
*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(String teamLead) {
        this.teamLead = teamLead;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(TeamMember teamMember) {
        if (teamMembers == null) {
            teamMembers = new ArrayList<>();
        }
        teamMembers.add(teamMember);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
