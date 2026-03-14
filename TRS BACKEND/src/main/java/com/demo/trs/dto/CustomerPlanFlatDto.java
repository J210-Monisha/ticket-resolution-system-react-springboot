package com.demo.trs.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerPlanFlatDto {
    private int customerId;
    private String customerName;
    private int planId;
    private String planName;
    private double price;
    private  LocalDate dateOfActivation;

    public CustomerPlanFlatDto(int customerId, String customerName, int planId, String planName, String price, LocalDate dateOfActivation) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.planId = planId;
        this.planName = planName;
        this.price = Double.parseDouble(price);
        this.dateOfActivation = dateOfActivation;
    }

    public CustomerPlanFlatDto() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateOfActivation() {
        return dateOfActivation;
    }

    public void setDateOfActivation(LocalDate dateOfActivation) {
        this.dateOfActivation = dateOfActivation;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
