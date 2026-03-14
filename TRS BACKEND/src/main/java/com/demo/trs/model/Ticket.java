package com.demo.trs.model;

import java.time.LocalDateTime;

import com.demo.trs.enums.TicketPriority;
import com.demo.trs.enums.TicketStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
	public class Ticket {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(nullable = false)
	    private String subject;

	    @Column(length = 1000)
	    private String issue;
	    
	    public LocalDateTime createdAt = LocalDateTime.now();

	    @Enumerated(EnumType.STRING)
	    private TicketPriority ticketPriority;

	    @Enumerated(EnumType.STRING)
	    private TicketStatus ticketStatus = TicketStatus.OPEN;

	    @ManyToOne
	    private Customer customer;

	    @ManyToOne
	    private Executive executive;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getIssue() {
			return issue;
		}

		public void setIssue(String issue) {
			this.issue = issue;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public TicketPriority getTicketPriority() {
			return ticketPriority;
		}

		public void setTicketPriority(TicketPriority ticketPriority) {
			this.ticketPriority = ticketPriority;
		}

		public TicketStatus getTicketStatus() {
			return ticketStatus;
		}

		public void setTicketStatus(TicketStatus ticketStatus) {
			this.ticketStatus = ticketStatus;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Executive getExecutive() {
			return executive;
		}

		public void setExecutive(Executive executive) {
			this.executive = executive;
		}
}

