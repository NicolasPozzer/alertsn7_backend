package com.demo.alertsn7_backend.service;

import com.demo.alertsn7_backend.model.Ticket;
import com.demo.alertsn7_backend.repository.IRepositoryTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private IRepositoryTicket repoTicket;


    @Override
    public List<Ticket> getTickets() {
        List<Ticket> listaTickets = repoTicket.findAll();
        return listaTickets;
    }

    @Override
    public void saveTicket(Ticket tic) {
        repoTicket.save(tic);
    }

    @Override
    public void deleteTicket(Long id) {
        repoTicket.deleteById(id);
    }

    @Override
    public Ticket findTicket(Long id) {
        Ticket tic = repoTicket.findById(id).orElse(null);
        return tic;
    }

    @Override
    public void editTicket(Ticket tic) {
        this.saveTicket(tic);
    }
}
