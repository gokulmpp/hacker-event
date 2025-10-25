package com.hackIt.events.controller.dto;
import jakarta.validation.constraints.NotBlank;
public class EventCreateRequest{
    @NotBlank(message = "event name is must")
    private String name;
    private String organizer;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
}
