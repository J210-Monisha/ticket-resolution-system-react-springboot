package com.demo.trs.dto;


import java.util.List;


public class CustomerPlanDto {
	
	 private int id;
	 private String name;
	 private String city;
	 private List<PlanDto> listplanDto;
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
	public List<PlanDto> getListplanDto() {
		return listplanDto;
	}
	public void setListplanDto(List<PlanDto> listplanDto) {
		this.listplanDto = listplanDto;
	}
	 
	 
}