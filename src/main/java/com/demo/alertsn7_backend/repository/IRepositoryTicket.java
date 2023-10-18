package com.demo.alertsn7_backend.repository;

import com.demo.alertsn7_backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryTicket extends JpaRepository<Ticket, Long> {
}
