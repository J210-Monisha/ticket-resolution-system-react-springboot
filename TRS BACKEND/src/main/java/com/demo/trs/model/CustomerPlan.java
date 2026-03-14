package com.demo.trs.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_plan")
	public class CustomerPlan {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "date_of_activation")
	    private LocalDate dateOfActivation;

	    @ManyToOne
	    private Customer customer;

	    @ManyToOne
	    private Plan plan;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public LocalDate getDateOfActivation() {
			return dateOfActivation;
		}

		public void setDateOfActivation(LocalDate dateOfActivation) {
			this.dateOfActivation = dateOfActivation;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Plan getPlan() {
			return plan;
		}

		public void setPlan(Plan plan) {
			this.plan = plan;
		}

	
	}
