package com.example.reservas.Controllers;

import com.example.reservas.DTO.HabitacionDTO;
import com.example.reservas.DTO.ReservaDTO;
import com.example.reservas.Models.Habitacion;
import com.example.reservas.Models.Reserva;
import com.example.reservas.Services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReservaController {

    private final ReservaService reservaService;
    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/reserva")
    public ReservaDTO generarReserva(@RequestParam("cedula") Integer cedula, @RequestParam("numero") Integer numero, @RequestParam("fecha") String fecha){
        return this.reservaService.crearReserva(cedula,numero,fecha);
    }

    @GetMapping("/reservas/{cedula}")
    public List<ReservaDTO> reservasPorCliente(@PathVariable("cedula") Integer cedula){
       return this.reservaService.reservasPorCliente(cedula);
    }

    @GetMapping("/habitaciones/{fecha}")
    public List<HabitacionDTO> habitacionesDisponiblesPorFecha(@PathVariable("fecha") String fecha){
        return reservaService.obtenerHabitacionesDisponiblesFecha(fecha);
    }

    @GetMapping("/habitaciones/tipo")
    public List<HabitacionDTO> habitacionesDisponiblesPorTipo(@RequestParam("tipo") String tipo, @RequestParam("fecha") String fecha){
        return reservaService.habitacionesDisponiblesPorTipo(fecha, tipo);
    }
}
