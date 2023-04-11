package com.example.reservas.Controllers;

import com.example.reservas.DTO.HabitacionDTO;
import com.example.reservas.Models.Habitacion;
import com.example.reservas.Services.HabitacionService;
import com.example.reservas.Services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HabitacionController {

    private final HabitacionService habitacionService;
    private final ReservaService reservaService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService, ReservaService reservaService){
        this.habitacionService=habitacionService;
        this.reservaService = reservaService;}

    @PostMapping("/habitacion")
    public HabitacionDTO crearHabitacion(@RequestBody HabitacionDTO habitacionDTO){
        return this.habitacionService.crear(habitacionDTO);
    }

    @PostMapping("/habitaciones")
    public ResponseEntity<Habitacion> crearHabitaciones(){
        this.habitacionService.crearHabitaciones();
        return new ResponseEntity("Habitaciones creadas exitosamente", HttpStatus.CREATED);
    }

}
