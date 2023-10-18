package com.demo.alertsn7_backend.controller;

import com.demo.alertsn7_backend.model.Ticket;
import com.demo.alertsn7_backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired //Inyectamos Dependencia
    private TicketService ticServ;

    /*End Points*/

    /*Lista de Tickets*/
    @GetMapping("/tickets/list")
    public List<Ticket> getTickets(){
        return ticServ.getTickets();
    }

    /*Crear Ticket*/
    @PostMapping("/tickets/crear")
    public String saveTicket(@RequestBody Ticket tic){
        ticServ.saveTicket(tic);
        return "El Ticket fue |Creado| correctamente";
    }

    /*Borrar Ticket*/
    @DeleteMapping("/tickets/borrar/{id}")
    public String deleteTicket(@PathVariable Long id){
        ticServ.deleteTicket(id);
        return "El Ticket fue |Eliminado| Correctamente!";
    }

    /*Buscar un Ticket*/
    @GetMapping("/tickets/unticket/{id}")
    public Ticket findTicket(@PathVariable Long id){
        return ticServ.findTicket(id);
    }

    /*Editar un ticket*/
    @PutMapping("/tickets/edit")
    public String editTicket(@RequestBody Ticket tic){
        ticServ.editTicket(tic);
        return "Ticket |Editado| Correctamente!";
    }

}
