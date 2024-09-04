package com.Protelcrm.Service;

import com.Protelcrm.Model.Subscription;
import com.Protelcrm.Repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    // Save a subscription
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    // Get a subscription by ID
    public Optional<Subscription> getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id);
    }

    // Get all subscriptions
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    // Delete a subscription by ID
    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

}
