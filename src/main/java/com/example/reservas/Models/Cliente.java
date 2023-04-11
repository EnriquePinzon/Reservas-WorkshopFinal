package com.example.reservas.Models;

import javax.persistence.*;

@Entity
@Table(name="Cliente")
public class Cliente {

    @Id
    @Column(name="cedula")
    private Integer cedula;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="direccion")
    private String direccion;
    @Column(name="edad")
    private Integer edad;
    @Column(name="correoElectronico")
    private String correoElectronico;
    @Column(name = "habilitada")
    private String cuentaHabilitada;

    @Column(name = "contrasena")
    private String contrasena;

    public Cliente(){
    }

    public Cliente(String nombre, String apellido, Integer cedula, String direccion, Integer edad, String correoElectronico, String cuentaHabilitada, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.cuentaHabilitada = cuentaHabilitada;
        this.contrasena = contrasena;
    }


    public Integer getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getCuentaHabilitada() {
        return cuentaHabilitada;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setCuentaHabilitada(String cuentaHabilitada) {
        this.cuentaHabilitada = cuentaHabilitada;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
