package com.example.reservas.Models;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Reserva")
public class Reserva {

    @Id
    @Column(name="codigoDeReserva")
    private UUID codigoDeReserva;
    @Column(name="fechaReserva")
    private LocalDate fechaReserva;
    @OneToOne
    @JoinColumn(name="numero")
    private Habitacion habitacion;
    @ManyToOne
    @JoinColumn(name="cedula")
    private Cliente cliente;
    @Column(name="totalAPagar")
    private Integer totalAPagar;

    public Reserva(){

    }

    public Reserva(LocalDate fechaReserva, Habitacion habitacion, Cliente cliente, Integer totalAPagar) {
        this.fechaReserva = fechaReserva;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.codigoDeReserva = UUID.randomUUID();
        this.totalAPagar = totalAPagar;
    }


    public UUID getCodigoDeReserva() {
        return codigoDeReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Integer getTotalAPagar() {
        return totalAPagar;
    }

    public void setCodigoDeReserva(UUID codigoDeReserva) {
        this.codigoDeReserva = codigoDeReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTotalAPagar(Integer totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
