package com.ubots.desafio.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ticket")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketApi {

    private final TicketService service;

    @PostMapping
    public void createTicket(@RequestBody TicketResource request){
        service.createTicket(request);
    }

    @PostMapping("/create-multiple")
    public void createTickets(@RequestBody List<TicketResource> requests){
        service.createTickets(requests);
    }

    @PutMapping("/finalize/{ticketId}")
    public TicketMessageResponse finalizeTicket(@PathVariable Long ticketId) {
            return service.finalizeTicket(ticketId);
    }

}
