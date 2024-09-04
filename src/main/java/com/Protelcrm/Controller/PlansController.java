package com.Protelcrm.Controller;

import com.Protelcrm.Model.Plans;
import com.Protelcrm.Service.PlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plans")
@CrossOrigin(origins = "http://localhost:63342") // Your frontend URL

public class PlansController {
    @Autowired
    private PlansService planService;

    @PostMapping("/plan")
    public ResponseEntity<Plans> createPlan(@RequestBody Plans plan) {
        Plans savedPlan = planService.savePlan(plan);
        return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plans> getPlanById(@PathVariable Long id) {
        Optional<Plans> plan = planService.getPlanById(id);
        return plan.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Plans>> getAllPlans() {
        List<Plans> plans = planService.getAllPlans();
        return ResponseEntity.ok(plans);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }


}
