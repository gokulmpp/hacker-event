package com.hacker.events.repository;

import com.hacker.events.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,String> {
    Event findByName(String name);

    boolean existsByName(String name);
}
