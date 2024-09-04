package com.Protelcrm.Model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_id;
    private String ticket_description;
    private String ticket_status;
    private Date ticket_date;

    @ManyToOne
    @JoinColumn(name="SubscriptionID")
    private Subscription subscription;

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTicket_description() {
        return ticket_description;
    }

    public void setTicket_description(String ticket_description) {
        this.ticket_description = ticket_description;
    }

    public String getTicket_status() {
        return ticket_status;
    }

    public void setTicket_status(String ticket_status) {
        this.ticket_status = ticket_status;
    }

    public Date getTicket_date() {
        return ticket_date;
    }

    public void setTicket_date(Date ticket_date) {
        this.ticket_date = ticket_date;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Tickets() {
    }

    public Tickets(Long ticket_id, String ticket_description, String ticket_status, Date ticket_date, Subscription subscription) {
        this.ticket_id = ticket_id;
        this.ticket_description = ticket_description;
        this.ticket_status = ticket_status;
        this.ticket_date = ticket_date;
        this.subscription = subscription;
    }
}
