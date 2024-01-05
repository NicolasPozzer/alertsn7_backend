package com.demo.alertsn7_backend.service;

import com.demo.alertsn7_backend.model.ApiCoin;
import com.demo.alertsn7_backend.model.Ticket;
import com.demo.alertsn7_backend.repository.IRepositoryTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlertaService implements IAlertaService{

    @Autowired
    private TicketService ticketServ;
    @Autowired
    private IRepositoryTicket repoTicket;
    @Autowired
    private ApiCoinService apiServ;
    @Autowired
    private BotService botServ;


        @Scheduled(fixedRate = 62000) // Ejecutar cada 42 segundos
        @Override
        public void emitirAlerta() {
            /*LLamar una sola vez a la lista de la api*/
            List<ApiCoin> listaApi = apiServ.listadoApiCoin();
            List<Ticket> listaTickets = ticketServ.getTickets();

            for (Ticket ticket : listaTickets) {
                for (ApiCoin coin : listaApi) {

                    if (ticket.getNombre().equals(coin.getBaseAsset())) {
                        /*Saber si es mayor*/
                        if (ticket.getEncendido() && "Encima".equals(ticket.getDireccion())
                                && coin.getLastPrice() > ticket.getPrecioEstablecido()) {

                            /*Enviar mensaje*/
                            String chatId = "1603260238";
                            String message = "🔔 Alerta para |"+ticket.getNombre()+
                                    "| ¡El Precio Supero los: ⬆ $"+ticket.getPrecioEstablecido();
                            botServ.sendMessage(chatId, message);

                            /*Cambiar el estado a -> Apagado*/
                            ticket.setEncendido(false);
                            ticket.setColor("table-secondary");
                            ticketServ.saveTicket(ticket); // Guardar el cambio en la base de datos
                        }

                        /*Saber si es menor*/
                        else if (ticket.getEncendido() && "Debajo".equals(ticket.getDireccion())
                                && coin.getLastPrice() < ticket.getPrecioEstablecido()) {

                            /*Enviar mensaje*/
                            String chatId = "1603260238";
                            String message = "🔔 Alerta para |"+ticket.getNombre()+
                                    "| ¡Precio cayó ⬇ por debajo de $"+ticket.getPrecioEstablecido();
                            botServ.sendMessage(chatId, message);

                            /*Cambiar el estado a -> Apagado*/
                            ticket.setEncendido(false);
                            ticket.setColor("table-secondary");
                            ticketServ.saveTicket(ticket); // Guardar el cambio en la base de datos
                        }
                    }
                }
            }
        }
    }
