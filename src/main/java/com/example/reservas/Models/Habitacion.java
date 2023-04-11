package com.example.reservas.Models;

import javax.persistence.*;

@Entity
@Table(name="Habitacion")
public class Habitacion {

    @Id
    @Column(name="numero")
    private Integer numero;
    @Column(name="tipoHabitacion")
    private String tipoHabitacion;
    @Column(name="precioBase")
    private Integer precioBase;

    public Habitacion(){

    }

    public Habitacion(Integer numero, String tipoHabitacion, Integer precioBase) {
        this.numero = numero;
        this.tipoHabitacion = tipoHabitacion;
        this.precioBase = precioBase;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public Integer getPrecioBase(){return precioBase;}

    public void setPrecioBase(Integer precioBase) {
        this.precioBase = precioBase;
    }
}
