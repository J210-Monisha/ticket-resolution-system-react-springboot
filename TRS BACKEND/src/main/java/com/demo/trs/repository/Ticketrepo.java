package com.demo.trs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.trs.model.Ticket;

import java.util.List;

@Repository
public interface Ticketrepo extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByCustomerId(int customerId);
}