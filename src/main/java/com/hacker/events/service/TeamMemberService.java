package com.hacker.events.service;

import com.hacker.events.controller.dto.TeamMemberCreateRequest;
import com.hacker.events.domain.TeamMember;
import com.hacker.events.repository.TeamMembersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TeamMemberService {
    private final TeamMembersRepository teamMembersRepository;

    public TeamMemberService(TeamMembersRepository teamMembersRepository){
        this.teamMembersRepository=teamMembersRepository;
    }
    @Transactional
    public String create(TeamMemberCreateRequest request){
        TeamMember teamMembers = new TeamMember(UUID.randomUUID().toString(), request.getName(), request.getEmail());
        teamMembersRepository.save(teamMembers);
        return teamMembers.getId();
    }

}
