package com.example.reservas.Services;

import com.example.reservas.DTO.HabitacionDTO;
import com.example.reservas.DTO.ReservaDTO;
import com.example.reservas.Exceptions.InvalidStatementException;
import com.example.reservas.Models.Cliente;
import com.example.reservas.Models.ConfirmacionReserva;
import com.example.reservas.Models.Habitacion;
import com.example.reservas.Models.Reserva;
import com.example.reservas.Repositories.ClienteRepository;
import com.example.reservas.Repositories.HabitacionRepository;
import com.example.reservas.Repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private ReservaRepository reservaRepository;
    private ClienteRepository clienteRepository;
    private HabitacionRepository habitacionRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, ClienteRepository clienteRepository, HabitacionRepository habitacionRepository)
    {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
        this.habitacionRepository = habitacionRepository;
    }


    public ReservaDTO crearReserva(Integer cedula, Integer numero, String fechaReserva) {
        if (cedula < 0 || numero < 0 || fechaReserva == null) {
            throw new InvalidStatementException("Los datos de la solicitud están incompletos o son incorrectos");
        }
        LocalDate date = StringToLocalDate(fechaReserva);
        if (date.isBefore(LocalDate.now())) {
            throw new InvalidStatementException("La fecha de reserva no puede ser anterior al día actual.");
        }
        Optional<Cliente> cliente = this.clienteRepository.findById(cedula);
        Optional<Habitacion> habitacion = this.habitacionRepository.findById(numero);

        if (cliente.isPresent() && habitacion.isPresent()) {
            List<HabitacionDTO> habitacionesDisponibles = ValidarHabitacionesDisponiblesFecha(date);
            if (habitacionesDisponibles.contains(habitacion.get())) {
                this.reservaRepository.save(new Reserva(date,habitacion.get(),cliente.get(),habitacion.get().getPrecioBase()));
                return new ReservaDTO(date,habitacion.get(),cliente.get(),habitacion.get().getPrecioBase());

        } else {
            throw new InvalidStatementException("La habitación no está disponible para la fecha seleccionada.");
            }
        }
        else{
            throw new InvalidStatementException("El cliente o la habitación no están registrados en base de datos.");
        }

    }


    public LocalDate StringToLocalDate(String fechaReserva){
        DateTimeFormatter formatter;
        try{
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } catch (DateTimeParseException e){
            throw new InvalidStatementException("Ingresó mal la fecha, debe ser dd-mm-year");
        }
        LocalDate localDate = LocalDate.parse(fechaReserva, formatter);
        return localDate;
    }


    public Integer calcularTotalPago(Habitacion habitacion){
        Integer base = habitacion.getPrecioBase();
        if (habitacion.getTipoHabitacion().equalsIgnoreCase("premium")){
            return base * 5/100;
        }
        return base;
    }



    public List<HabitacionDTO> ValidarHabitacionesDisponiblesFecha(LocalDate fecha){
        List<Habitacion> disponibles = this.habitacionRepository.findAll();
        List<Habitacion> habReservas = new ArrayList<>();

        List<Reserva> habitacionesReservadas = this.reservaRepository.findAll();
        habitacionesReservadas.stream()
                .filter(reserva -> reserva.getFechaReserva().equals(fecha))
                .forEach(reserva -> habReservas.add(reserva.getHabitacion()));
        disponibles = disponibles.stream()
                .filter(habitacion -> !habReservas.contains(habitacion))
                .collect(Collectors.toList());
        List<HabitacionDTO> retornoDisponibles = new ArrayList<>();
        disponibles.stream()
                .forEach(habitacion -> retornoDisponibles.add(new HabitacionDTO(habitacion.getNumero(),habitacion.getTipoHabitacion(),habitacion.getPrecioBase())));
        return retornoDisponibles;
    }

    public void fechaValidator (LocalDate fecha){
        if(fecha.isBefore(LocalDate.now())){
            throw  new InvalidStatementException("La fecha es errónea.");
        }
    }



    public List<HabitacionDTO> obtenerHabitacionesDisponiblesFecha(String fecha){
        LocalDate date = StringToLocalDate(fecha);

        return ValidarHabitacionesDisponiblesFecha(date);
    }


    public List<HabitacionDTO>habitacionesDisponiblesPorTipo(String fecha, String tipo){
        LocalDate date = StringToLocalDate(fecha);
        List<HabitacionDTO> disponibles = ValidarHabitacionesDisponiblesFecha(date);
        disponibles = disponibles.stream()
                .filter(habitacion -> habitacion.getTipoHabitacion().equals(tipo))
                .collect(Collectors.toList());
        return disponibles;
    }

    public List<ReservaDTO> reservasPorCliente(Integer cedula){
        Optional<Cliente> cliente = clienteRepository.findById(cedula);
        if(!cliente.isPresent()){
            throw new InvalidStatementException("La cedula del cliente no esta registrado");
        }
        List<Reserva> reservasCliente = this.reservaRepository.findAll();
        reservasCliente = reservasCliente.stream()
                .filter(reserva -> reserva.getCliente().getCedula().equals(cedula))
                .collect(Collectors.toList());
        List<ReservaDTO> reservasDTOS = new ArrayList<>();
        reservasCliente.stream()
                .forEach(reserva -> reservasDTOS.add(new ReservaDTO(reserva.getFechaReserva(),reserva.getHabitacion(),reserva.getCliente()
                        ,reserva.getTotalAPagar())));
        return reservasDTOS;
    }



}


