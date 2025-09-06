package com.ubots.desafio.ticket;

import com.ubots.desafio.common.StatusEnum;
import com.ubots.desafio.common.TeamEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<TicketModel, Long> {
    Optional<TicketModel> findFirstByTeamAndStatusOrderByCreatedAtAsc(TeamEnum team, StatusEnum status);
}

