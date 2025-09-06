package com.ubots.desafio.agent;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/agent")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AgentApi {

    private final AgentService service;

    @PostMapping
    public void createAgent(@RequestBody AgentResource request){
        service.createAgent(request);
    }

    @PostMapping("/create-multiple")
    public void createAgents(@RequestBody List<AgentResource> requests){
        service.createAgents(requests);
    }
}
