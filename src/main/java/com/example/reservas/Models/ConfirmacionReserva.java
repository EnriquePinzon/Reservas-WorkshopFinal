package com.example.reservas.Models;

import java.time.LocalDate;
import java.util.UUID;

public class ConfirmacionReserva {
    private Double total;
    private UUID reserva;
    private Integer habitacion;
    private LocalDate fechaReserva;

    public ConfirmacionReserva(Double total, UUID reserva, Integer habitacion, LocalDate fechaReserva) {
        this.total = total;
        this.reserva = reserva;
        this.habitacion = habitacion;
        this.fechaReserva = fechaReserva;
    }

    public Double getTotal() {
        return total;
    }

    public UUID getReserva() {
        return reserva;
    }

    public Integer getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

}
