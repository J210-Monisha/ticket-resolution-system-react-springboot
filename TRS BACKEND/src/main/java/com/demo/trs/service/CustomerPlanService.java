package com.demo.trs.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.trs.dto.CustomerPlanDto;
import com.demo.trs.dto.PlanDto;
import com.demo.trs.model.CustomerPlan;
import com.demo.trs.model.Customer;
import com.demo.trs.model.Plan;
import com.demo.trs.repository.CustomerPlanRepository;

@Service
public class CustomerPlanService {

    private final CustomerPlanRepository customerPlanRepository;

    @Autowired
    public CustomerPlanService(CustomerPlanRepository customerPlanRepository) {
        this.customerPlanRepository = customerPlanRepository;
    }

    public CustomerPlan add(Customer customer, Plan plan) {
        CustomerPlan customerPlan = new CustomerPlan();
        customerPlan.setDateOfActivation(LocalDate.now());
        customerPlan.setCustomer(customer);
        customerPlan.setPlan(plan);
        return customerPlanRepository.save(customerPlan);
    }

    public List<CustomerPlanDto> getAllCustomerPlans() {
        List<CustomerPlan> customerPlans = customerPlanRepository.findAll();

        // Group by customer and collect plan info
        return customerPlans.stream()
                .collect(Collectors.groupingBy(CustomerPlan::getCustomer))
                .entrySet().stream()
                .map(entry -> {
                    Customer customer = entry.getKey();
                    List<PlanDto> planDtos = entry.getValue().stream()
                            .map(cp -> {
                                Plan plan = cp.getPlan();
                                PlanDto dto = new PlanDto();
                                dto.setId(plan.getId());
                                dto.setPlanName(plan.getPlanName());
                                dto.setPrice(plan.getPrice());
                                dto.setDetails(plan.getDetails());
                                return dto;
                            })
                            .collect(Collectors.toList());

                    CustomerPlanDto customerPlanDto = new CustomerPlanDto();
                    customerPlanDto.setId(customer.getId());
                    customerPlanDto.setName(customer.getName());
                    customerPlanDto.setCity(customer.getCity());
                    customerPlanDto.setListplanDto(planDtos);
                    return customerPlanDto;
                })
                .collect(Collectors.toList());
    }
}

