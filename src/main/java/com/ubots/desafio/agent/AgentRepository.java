package com.ubots.desafio.agent;

import com.ubots.desafio.common.TeamEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepository extends JpaRepository<AgentModel, Long> {
    List<AgentModel> findByTeam(TeamEnum team);
}
