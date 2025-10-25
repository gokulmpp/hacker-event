package com.hackIt.events.repository;

import com.hackIt.events.domain.Team;
import org.apache.tomcat.util.http.parser.TE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,String> {
    boolean existsByTeamName(String name);
}
