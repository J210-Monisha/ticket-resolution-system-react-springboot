package com.demo.trs.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.trs.dto.CustomerDto;
import com.demo.trs.model.Customer;

@Component
public class CustomerMapper {
	public CustomerDto fromEntitytoDto(Customer customer) {
		CustomerDto dto = new CustomerDto(
		customer.getId(),
		customer.getCity(),
		customer.getName()
		);
		return dto;
	}
	
	public List<CustomerDto> fromEntityListToDtoList(List<Customer> list){
		List<CustomerDto> listDto = new ArrayList<>();
		list.forEach(c->{
			CustomerDto dto= fromEntitytoDto(c);
			listDto.add(dto);
			
		});
		return listDto;
	}
}
