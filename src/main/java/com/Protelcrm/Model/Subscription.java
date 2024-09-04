package com.Protelcrm.Model;

import jakarta.persistence.*;
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SubscriptionID;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer Customer;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plans Plan;

    public Subscription() {
    }

    public Subscription(Long subscriptionID, Customer customer, Plans plan) {
        SubscriptionID = subscriptionID;
        Customer = customer;
        Plan = plan;
    }

    public Long getSubscriptionID() {
        return SubscriptionID;
    }

    public void setSubscriptionID(Long subscriptionID) {
        SubscriptionID = subscriptionID;
    }

    public com.Protelcrm.Model.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(com.Protelcrm.Model.Customer customer) {
        Customer = customer;
    }

    public Plans getPlan() {
        return Plan;
    }

    public void setPlan(Plans plan) {
        Plan = plan;
    }
}
