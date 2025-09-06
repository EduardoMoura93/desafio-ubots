package com.ubots.desafio.agent;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AgentService {

    private final AgentRepository repository;
    private final AgentAssemblerMapper mapper;

    public void createAgent(AgentResource request) {
        repository.save(mapper.toEntity(request));
    }

    public void createAgents(List<AgentResource> requests) {
        repository.saveAll(mapper.toEntities(requests));
    }
}
