package com.hacker.events.service;

import com.hacker.events.TeamException;
import com.hacker.events.controller.dto.TeamCreateRequest;
import com.hacker.events.domain.Event;
import com.hacker.events.domain.Team;
import com.hacker.events.domain.TeamMember;
import com.hacker.events.repository.EventRepository;
import com.hacker.events.repository.TeamMembersRepository;
import com.hacker.events.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {
    private final EventRepository eventRepository;
    private final TeamRepository teamRepository;
    private final TeamMembersRepository teamMembersRepository;

    public TeamService(TeamRepository teamRepository,TeamMembersRepository teamMembersRepository,EventRepository eventRepository) {
        this.teamRepository = teamRepository;
        this.teamMembersRepository = teamMembersRepository;
        this.eventRepository=eventRepository;
    }

    @Transactional
    public String create(TeamCreateRequest request){
        if(teamRepository.existsByTeamName(request.getTeamName())){
            throw new TeamException("event name must be unique");
        }
        Optional<TeamMember> teamMembers = teamMembersRepository.findById(request.getTeamMemberId());
        var teamMember = teamMembers.get();
        Optional<Event> event = eventRepository.findById(request.getEventId());
        if (event.isEmpty()) {
            throw new TeamException("Event not found");
        }
        Team team = new Team(UUID.randomUUID().toString(), request.getTeamName(), request.getTeamLead());
        team.setEvent(event.get());
        team.addTeamMember(teamMember);
        teamRepository.save(team);
        return team.getId();
    }
}
