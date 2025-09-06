package com.ubots.desafio.agent;

import com.ubots.desafio.common.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgentAssemblerMapper extends AbstractMapper<AgentModel, AgentResource> {
}
