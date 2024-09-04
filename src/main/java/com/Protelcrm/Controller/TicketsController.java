package com.Protelcrm.Controller;

import com.Protelcrm.Model.Subscription;
import com.Protelcrm.Model.Tickets;
import com.Protelcrm.Model.TicketsDTO;
import com.Protelcrm.Repository.SubscriptionRepository;
import com.Protelcrm.Service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets/ticket")
@CrossOrigin(origins = "http://localhost:63342") // Your frontend URL

public class TicketsController {

    @Autowired
    private TicketsService ticketsService;
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @PostMapping
    public ResponseEntity<Tickets> createTicket(@RequestBody TicketsDTO ticketsDTO){
        try{
            Optional<Subscription> subscription = subscriptionRepository.findById(ticketsDTO.getSubscriptionID());
            if(subscription.isPresent()){
                Tickets tickets = new Tickets();
                tickets.setTicket_description(ticketsDTO.getTicket_description());
                tickets.setTicket_date(ticketsDTO.getTicket_date());
                tickets.setTicket_status(ticketsDTO.getTicket_status());
                tickets.setSubscription(subscription.get());
                ticketsService.createTicket(tickets);
                return new ResponseEntity<>(tickets, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Tickets>> getAllTickets(){
        try{
            return new ResponseEntity<>(ticketsService.getAllTickets(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Tickets> getTicket(@PathVariable("ticketId") Long ticketId){
        try{
            return new ResponseEntity<>(ticketsService.getTicketById(ticketId).orElse(null), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{ticketId}")
    public ResponseEntity<Tickets> updateTicket(@RequestBody TicketsDTO ticketsDTO, @PathVariable Long ticketId){
        try{
            return new ResponseEntity<>(ticketsService.updateTicketById(ticketId, ticketsDTO).orElse(null), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long ticketId){
        try{
            return new ResponseEntity<>(ticketsService.deleteTicketById(ticketId), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}