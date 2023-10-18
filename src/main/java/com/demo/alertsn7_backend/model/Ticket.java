package com.demo.alertsn7_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private Double precioEstablecido;
    private Boolean direccion;  //  False = Short | True = Long

    public Ticket() {
    }

    public Ticket(Long id, String nombre, Double precioEstablecido, Boolean direccion) {
        this.id = id;
        this.nombre = nombre;
        this.precioEstablecido = precioEstablecido;
        this.direccion = direccion;
    }
}
