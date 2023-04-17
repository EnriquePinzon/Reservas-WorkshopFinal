package com.example.reservas;

import com.example.reservas.DTO.HabitacionDTO;
import com.example.reservas.DTO.ReservaDTO;
import com.example.reservas.Exceptions.InvalidStatementException;

import com.example.reservas.Models.Cliente;
import com.example.reservas.Models.Habitacion;
import com.example.reservas.Models.Reserva;
import com.example.reservas.Repositories.ClienteRepository;
import com.example.reservas.Repositories.HabitacionRepository;
import com.example.reservas.Repositories.ReservaRepository;
import com.example.reservas.Services.ReservaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ReservaServiceTest {

    ReservaRepository reservaRepository;
    HabitacionRepository habitacionRepository;
    ClienteRepository clienteRepository;
    ReservaService reservaService;


    @Before
    public void setUp() {
        this.reservaRepository = mock(ReservaRepository.class);
        this.habitacionRepository = mock(HabitacionRepository.class);
        this.clienteRepository = mock(ClienteRepository.class);
        this.reservaService = new ReservaService(reservaRepository, clienteRepository, habitacionRepository);
    }

    @Test(expected = DateTimeParseException.class)
    public void probarFechaConFormatoErroneo() {
        String fecha = "2015/04/15";
        LocalDate date = this.reservaService.StringToLocalDate(fecha);
    }

    @Test
    public void probarFechaFormatoCorrecto() {
        String fecha = "26-06-2001";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateComparative = LocalDate.parse(fecha, formatter);

        LocalDate date = this.reservaService.StringToLocalDate(fecha);

        assertTrue(date.equals(dateComparative));
    }

    @Test(expected = InvalidStatementException.class)
    public void probarFechaValidaAnteriorActual() {
        String fecha = "15-05-2015";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateComparative = LocalDate.parse(fecha,formatter);
        this.reservaService.fechaValidator(dateComparative);
    }

    @Test
    public void probarFechaValidaDespuesActual() {
        String fecha = "15-05-2023";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateComparative = LocalDate.parse(fecha,formatter);
        this.reservaService.fechaValidator(dateComparative);
        assertTrue(dateComparative.isAfter(LocalDate.now()));
    }

    @Test
    public void obtenerHabitacionesDisponiblesFechaValida() {
        String fecha = "15-05-2023";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Habitacion> disponibles = new ArrayList<>(Arrays.asList(new Habitacion(1, "estandar", 100),
                new Habitacion(2, "estandar", 100),
                new Habitacion(3, "estandar", 100)));
        when(habitacionRepository.findAll()).thenReturn(disponibles);

        List<HabitacionDTO> habitaciones = this.reservaService.obtenerHabitacionesDisponiblesFecha(fecha);
        assertTrue(!habitaciones.isEmpty());
    }

    @Test
    public void obtenerHabitacionesDisponiblesFechaNoValida() {
        String fecha = "15-05-2005";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateComparative = LocalDate.parse(fecha,formatter);
        List<Habitacion> disponibles = new ArrayList<>(Arrays.asList(new Habitacion(1, "estandar", 100),
                new Habitacion(2, "estandar", 100),
                new Habitacion(3, "estandar", 100)));
        when(habitacionRepository.findAll()).thenReturn(disponibles);

        List<HabitacionDTO> habitaciones = this.reservaService.obtenerHabitacionesDisponiblesFecha(fecha);
    }
    @Test
    public void obtenerHabitacionesDisponiblesFiltradasPorTipoHabitacionExistente() {
        //Arrange
        Habitacion habitacion1 = new Habitacion(1, "Estandar", 100);
        Habitacion habitacion2 = new Habitacion(2, "Premium", 150);
        Habitacion habitacion3 = new Habitacion(3, "Premium", 150);
        Cliente cliente = new Cliente();
        Reserva reserva = new Reserva(LocalDate.now(), habitacion2, cliente,190 );
        this.reservaRepository.save(reserva);
        //Act
        List<HabitacionDTO> habitacionesDisponibles = this.reservaService.habitacionesDisponiblesPorTipo("12-05-2023","premium");
        //Assert
        Assertions.assertTrue(habitacionesDisponibles.isEmpty()); //debe haber una sola habitación disponible de tipo premium

    }

    
    @Test
    public void obtenerReservasPorClienteInexistente() {
        //Arrange
        int cedulaInexistente = 12345678;

        //Act & Assert
        Assertions.assertThrows(InvalidStatementException.class, () -> {
            this.reservaService.reservasPorCliente(cedulaInexistente);
        });
    }




}






