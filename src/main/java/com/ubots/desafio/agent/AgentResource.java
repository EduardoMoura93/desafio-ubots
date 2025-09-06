package com.ubots.desafio.agent;

import com.ubots.desafio.common.TeamEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentResource {

    @NotBlank(message = "O nome do agente é obrigatório")
    private String name;
    @NotNull(message = "O time do agente é obrigatório")
    private TeamEnum team;

}
