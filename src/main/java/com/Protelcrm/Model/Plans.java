package com.Protelcrm.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plan_id;
    private String plan_name;
    private String plan_type;
    private Double plan_price;

    public Plans() {
    }

    public Plans(Long plan_id, String plan_name, String plan_type, Double plan_price) {
        this.plan_id = plan_id;
        this.plan_name = plan_name;
        this.plan_type = plan_type;
        this.plan_price = plan_price;
    }

    public Long getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(String plan_type) {
        this.plan_type = plan_type;
    }

    public Double getPlan_price() {
        return plan_price;
    }

    public void setPlan_price(Double plan_price) {
        this.plan_price = plan_price;
    }
}
