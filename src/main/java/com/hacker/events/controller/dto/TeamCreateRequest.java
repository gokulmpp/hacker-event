package com.hacker.events.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class TeamCreateRequest {
    private String teamMemberId;

    @NotBlank(message = "team name should not be blank")
    private String teamName;
    private String teamLead;

    public String getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(String teamMemberId) {
        this.teamMemberId = teamMemberId;
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
}
