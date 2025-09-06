package com.ubots.desafio.ticket;

import com.ubots.desafio.common.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketAssemblerMapper extends AbstractMapper<TicketModel, TicketResource> {
}
