package com.Protelcrm.Service;

import com.Protelcrm.Model.Plans;
import com.Protelcrm.Repository.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlansService {
    @Autowired
    private PlansRepository plansRepository;
    public Plans savePlan(Plans plan) {
        return plansRepository.save(plan);
    }

    public Optional<Plans> getPlanById(Long id) {
        return plansRepository.findById(id);
    }

    public List<Plans> getAllPlans() {
        return plansRepository.findAll();
    }

    public void deletePlan(Long id) {
        plansRepository.deleteById(id);
    }

    public Optional<Plans> findById(Long id) {
        return plansRepository.findById(id);
    }

}
