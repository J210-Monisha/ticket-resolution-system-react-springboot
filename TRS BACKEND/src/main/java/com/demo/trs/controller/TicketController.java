package com.demo.trs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.trs.dto.TicketDto;
import com.demo.trs.model.Ticket;
import com.demo.trs.service.TicketService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/all")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
    
    @GetMapping("/user/{userId}")
    public List<Ticket> getTicketsByUser(@PathVariable int userId) {
        return ticketService.getTicketsByUser(userId);
    }
    
    @PutMapping("/resolve/{id}")
    public Ticket resolveTicket(@PathVariable int id){
        return ticketService.resolveTicket(id);
    }

    @PostMapping("/add/{customerId}")
    public ResponseEntity<?> postTicket(@PathVariable int customerId,
                             @RequestBody TicketDto ticketDto){
        try {
            ticketService.add(customerId, ticketDto);
        } catch(IllegalArgumentException | NullPointerException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Ticket created successfully");
    }
    
    @PutMapping("/assign/{ticketId}/{executiveId}")
    public Ticket assignExecutive(@PathVariable int ticketId,
                                  @PathVariable int executiveId){
        return ticketService.assignExecutive(ticketId, executiveId);
    }
}