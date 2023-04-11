package com.example.reservas.DTO;

import com.example.reservas.Models.Cliente;
import com.example.reservas.Models.Habitacion;

import java.time.LocalDate;

public class ReservaDTO {
    private LocalDate fechaReserva;
    private Habitacion habitacion;
    private Cliente cliente;
    private Integer totalPago;

    public ReservaDTO() {
    }

    public ReservaDTO(LocalDate fechaReserva, Habitacion habitacion, Cliente cliente, Integer totalPago) {
        this.fechaReserva = fechaReserva;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.totalPago = totalPago;
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

    public void setTotalPago(Integer totalPago) {
        this.totalPago = totalPago;
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

    public Integer getTotalPago() {
        return totalPago;
    }
}
