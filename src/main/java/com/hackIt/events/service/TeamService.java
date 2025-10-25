package com.hackIt.events.service;

import com.hackIt.events.TeamException;
import com.hackIt.events.controller.dto.TeamCreateRequest;
import com.hackIt.events.domain.Team;
import com.hackIt.events.domain.TeamMember;
import com.hackIt.events.repository.TeamMembersRepository;
import com.hackIt.events.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMembersRepository teamMembersRepository;
    public TeamService(TeamRepository teamRepository,TeamMembersRepository teamMembersRepository){
        this.teamRepository=teamRepository;
        this.teamMembersRepository=teamMembersRepository;
    }

    @Transactional
    public String create(TeamCreateRequest request){
        if(teamRepository.existsByTeamName(request.getTeamName())){
            throw new TeamException("event name must be unique");
        }
        Optional<TeamMember> teamMembers=teamMembersRepository.findById(request.getTeamMemberId());
        Team team = new Team();
        team.setId(UUID.randomUUID().toString());
        team.setTeamName(request.getTeamName());
        team.setTeamLead(request.getTeamLead());
        team.addTeamMember(teamMembers.get());
        teamRepository.save(team);
        return team.getId();
    }
}
