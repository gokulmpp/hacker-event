package com.hackIt.events.controller;

import com.hackIt.events.controller.dto.EventCreateRequest;
import com.hackIt.events.controller.dto.TeamCreateRequest;
import com.hackIt.events.controller.dto.TeamMemberCreateRequest;
import com.hackIt.events.service.EventsService;
import com.hackIt.events.service.TeamMemberService;
import com.hackIt.events.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main")
@Validated
public class EventController {
    private final EventsService eventsService;
    private final TeamService teamService;
    private final TeamMemberService teamMemberService;
    public EventController(EventsService eventsService,TeamService teamService,TeamMemberService teamMemberService) {
        this.eventsService=eventsService;
        this.teamService=teamService;
        this.teamMemberService=teamMemberService;
    }

    @PostMapping("eventCreate")
    public ResponseEntity<String> eventCreate(@Valid @RequestBody EventCreateRequest request){
        return ResponseEntity.ok(eventsService.create(request));
    }

    @PostMapping("teamCreate")
    public ResponseEntity<String> teamCreate(@Valid @RequestBody TeamCreateRequest request){
        return ResponseEntity.ok(teamService.create(request));
    }

    @PostMapping("/teamMemberCreate")
    public ResponseEntity<String> teamMemberCreate(@Valid @RequestBody TeamMemberCreateRequest request){
        return ResponseEntity.ok(teamMemberService.create(request));
    }
}
