package com.demo.trs.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerDto {
	    private int id;
	    private String name;
	    private String city;
	    private int totalNumberOfTickets;
	    private int numberOfTicketsWithPriority;
	    
		
		
		public CustomerDto(int id, String name, String city) {
			super();
			this.id = id;
			this.name = name;
			this.city = city;
			this.totalNumberOfTickets = totalNumberOfTickets;
			
		}
		
		  public CustomerDto(int id, String name, String city, long totalNumberOfTickets) {
		        this.id = id;
		        this.name = name;
		        this.city = city;
		        this.totalNumberOfTickets = (int)totalNumberOfTickets;
		    }

		public CustomerDto() {
			
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getTotalNumberOfTickets() {
			return totalNumberOfTickets;
		}
		public void setTotalNumberOfTickets(int totalNumberOfTickets) {
			this.totalNumberOfTickets = totalNumberOfTickets;
		}
		public int getNumberOfTicketsWithPriority() {
			return numberOfTicketsWithPriority;
		}
		public void setNumberOfTicketsWithPriority(int numberOfTicketsWithPriority) {
			this.numberOfTicketsWithPriority = numberOfTicketsWithPriority;
		}
	    
}
