package com.hacker.events.repository;

import com.hacker.events.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,String> {
    boolean existsByTeamName(String name);
}
