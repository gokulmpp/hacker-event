package com.hacker.events.service;

import com.hacker.events.TeamException;
import com.hacker.events.controller.dto.TeamCreateRequest;
import com.hacker.events.domain.Team;
import com.hacker.events.domain.TeamMember;
import com.hacker.events.repository.TeamMembersRepository;
import com.hacker.events.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMembersRepository teamMembersRepository;

    public TeamService(TeamRepository teamRepository,TeamMembersRepository teamMembersRepository) {
        this.teamRepository = teamRepository;
        this.teamMembersRepository = teamMembersRepository;
    }

    @Transactional
    public String create(TeamCreateRequest request){
        if(teamRepository.existsByTeamName(request.getTeamName())){
            throw new TeamException("event name must be unique");
        }
        Optional<TeamMember> teamMembers = teamMembersRepository.findById(request.getTeamMemberId());
        var teamMember = teamMembers.get();

        Team team = new Team(UUID.randomUUID().toString(), request.getTeamName(), request.getTeamLead());
        team.addTeamMember(teamMember);
        teamRepository.save(team);
        return team.getId();
    }
}
