package com.ubots.desafio.ticket;

import com.ubots.desafio.agent.AgentModel;
import com.ubots.desafio.agent.AgentRepository;
import com.ubots.desafio.common.StatusEnum;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final AgentRepository agentRepository;
    private final TicketAssemblerMapper mapper;

    private static final int MAX_LOAD = 3;

    public void createTicket(TicketResource request) {

        TicketModel ticket = mapper.toEntity(request);

        List<AgentModel> agents = agentRepository.findByTeam(request.getTeam());

        AgentModel availableAgent = agents.stream()
                .filter(agent -> agent.getActiveLoad() < MAX_LOAD)
                .min(Comparator.comparingInt(AgentModel::getActiveLoad))
                .orElse(null);

        if (availableAgent != null) {
            ticket.setAgent(availableAgent);
            ticket.setStatus(StatusEnum.EM_ATENDIMENTO);
            availableAgent.setActiveLoad(availableAgent.getActiveLoad() + 1);
            agentRepository.save(availableAgent);
        } else {
            ticket.setAgent(null);
            ticket.setStatus(StatusEnum.NA_FILA);
        }

        ticketRepository.save(ticket);
    }

    public void createTickets(List<TicketResource> requests) {
        requests.forEach(this::createTicket);
    }

    @Transactional
    public TicketMessageResponse finalizeTicket(Long ticketId) {
        TicketModel ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado"));

        if (ticket.getStatus() == StatusEnum.FINALIZADO) {
            throw new RuntimeException("Ticket já está finalizado");
        }

        AgentModel agent = ticket.getAgent();

        ticket.setStatus(StatusEnum.FINALIZADO);
        ticket.setAgent(null);
        ticketRepository.save(ticket);

        if (agent != null) {
            agent.setActiveLoad(agent.getActiveLoad() - 1);
            agentRepository.save(agent);

            TicketModel nextTicket = ticketRepository.findFirstByTeamAndStatusOrderByCreatedAtAsc(agent.getTeam(), StatusEnum.NA_FILA)
                    .orElse(null);

            if (nextTicket != null) {
                nextTicket.setAgent(agent);
                nextTicket.setStatus(StatusEnum.EM_ATENDIMENTO);
                ticketRepository.save(nextTicket);

                agent.setActiveLoad(agent.getActiveLoad() + 1);
                agentRepository.save(agent);
            }
        }

        return new TicketMessageResponse("Ticket finalizado com sucesso!");
    }

}

