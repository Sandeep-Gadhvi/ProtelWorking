package com.Protelcrm.Repository;

import com.Protelcrm.Model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {
}
