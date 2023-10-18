package com.demo.alertsn7_backend.service;

import com.demo.alertsn7_backend.model.Ticket;

import java.util.List;

public interface ITicketService {

    public List<Ticket> getTickets();

    public void saveTicket(Ticket tic);

    public void deleteTicket(Long id);

    public Ticket findTicket(Long id);

    public void editTicket(Ticket tic);

}
