package com.demo.trs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.trs.dto.TicketDto;
import com.demo.trs.enums.TicketPriority;
import com.demo.trs.enums.TicketStatus;
import com.demo.trs.model.Customer;
import com.demo.trs.model.Executive;
import com.demo.trs.model.Ticket;
import com.demo.trs.repository.ExecutiveRepository;
import com.demo.trs.repository.Ticketrepo;

@Service
public class TicketService {

    private final Ticketrepo ticketRepository;
    private final CustomerService customerService;
    private final ExecutiveRepository executiveRepository;

    public TicketService(
            Ticketrepo ticketRepository,
            CustomerService customerService,
            ExecutiveRepository executiveRepository) {

        this.ticketRepository = ticketRepository;
        this.customerService = customerService;
        this.executiveRepository = executiveRepository;
    }

    // Add ticket from frontend
    public Ticket add(int customerId, TicketDto ticketDto) {

        if (ticketDto.getPriority() == null)
            throw new NullPointerException("Priority needs to have a value");

        TicketPriority priority;
        try {
            priority = TicketPriority.valueOf(ticketDto.getPriority().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Priority Value");
        }

        Customer customer = customerService.getById(customerId);

        Ticket ticket = new Ticket();
        ticket.setSubject(ticketDto.getSubject());
        ticket.setIssue(ticketDto.getIssue());
        ticket.setTicketPriority(priority);
        ticket.setTicketStatus(TicketStatus.OPEN);
        ticket.setCustomer(customer);

        return ticketRepository.save(ticket);
    }

    // Get all tickets (admin)
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Get tickets by user (user dashboard)
    public List<Ticket> getTicketsByUser(int userId) {
        return ticketRepository.findByCustomerId(userId);
    }

    // Resolve a ticket (admin/executive)
    public Ticket resolveTicket(int id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setTicketStatus(TicketStatus.RESOLVED);
        return ticketRepository.save(ticket);
    }

    // Assign an executive to a ticket (admin)
    public Ticket assignExecutive(int ticketId, int executiveId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        Executive executive = executiveRepository.findById(executiveId)
                .orElseThrow(() -> new RuntimeException("Executive not found"));

        ticket.setExecutive(executive);
        ticket.setTicketStatus(TicketStatus.IN_PROGRESS);
        return ticketRepository.save(ticket);
    }
}