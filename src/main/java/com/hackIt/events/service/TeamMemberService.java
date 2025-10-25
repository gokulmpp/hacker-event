package com.hackIt.events.service;

import com.hackIt.events.controller.dto.TeamMemberCreateRequest;
import com.hackIt.events.domain.TeamMember;
import com.hackIt.events.repository.TeamMembersRepository;
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
        TeamMember teamMembers=new TeamMember();
        teamMembers.setId(UUID.randomUUID().toString());
        teamMembers.setName(request.getName());
        teamMembers.setEmail(request.getEmail());
        teamMembersRepository.save(teamMembers);
        return teamMembers.getId();
    }

}
