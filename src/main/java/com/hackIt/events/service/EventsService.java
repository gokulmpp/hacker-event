package com.hackIt.events.service;

import com.hackIt.events.controller.dto.EventCreateRequest;
import com.hackIt.events.domain.Event;
import com.hackIt.events.repository.EventRepository;
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
        Event event=new Event();
        event.setId(UUID.randomUUID().toString());
        event.setName(request.getName());
        event.setOrganizer(request.getOrganizer());
        eventRepository.save(event);
        return event.getId();
    }
}
