package com.ubots.desafio.ticket;

import com.ubots.desafio.common.TeamEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResource {
    private String topic;
    private TeamEnum team;
}
