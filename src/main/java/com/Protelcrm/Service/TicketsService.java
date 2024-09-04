package com.Protelcrm.Service;

import com.Protelcrm.Model.Tickets;
import com.Protelcrm.Model.TicketsDTO;
import com.Protelcrm.Repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketsService {

    @Autowired
    private TicketsRepository ticketsRepository;


    // Convert TicketsDTO to Tickets entity

    public void createTicket(Tickets tickets) {
        ticketsRepository.save(tickets);
    }

    public List<Tickets> getAllTickets() {
        return ticketsRepository.findAll();
    }

    public Optional<Tickets> getTicketById(Long id) {
        return ticketsRepository.findById(id);
    }

    public Optional<Tickets> deleteTicketById(Long id) {
        if(ticketsRepository.existsById(id)) {
            ticketsRepository.deleteById(id);
            return ticketsRepository.findById(id);
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<Tickets> updateTicketById(Long id, TicketsDTO tickets) {
        Optional<Tickets> ticketsOptional = ticketsRepository.findById(id);
        if (ticketsOptional.isPresent()) {
            if (tickets.getTicket_date() != null) {
                ticketsOptional.get().setTicket_date(tickets.getTicket_date());
            }
            if(tickets.getTicket_description() != null) {
                ticketsOptional.get().setTicket_description(tickets.getTicket_description());
            }
            if(tickets.getTicket_status() != null) {
                ticketsOptional.get().setTicket_status(tickets.getTicket_status());
            }
            return Optional.of(ticketsRepository.save(ticketsOptional.get()));
        }
        return Optional.empty();
    }
}