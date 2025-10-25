package com.hacker.events.service;

import com.hacker.events.controller.dto.EventCreateRequest;
import com.hacker.events.domain.Event;
import com.hacker.events.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.EventException;

import java.util.UUID;

@Service
public class EventsService {
    private final EventRepository eventRepository;

    public EventsService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    @Transactional
    public String create(EventCreateRequest request){
        if(eventRepository.existsByName(request.getName())){
            throw new EventException((short) 0,"event name must be unique");
        }
        var event = new Event(UUID.randomUUID().toString(), request.getName(), request.getOrganizer());
        eventRepository.save(event);
        return event.getId();
    }
}
