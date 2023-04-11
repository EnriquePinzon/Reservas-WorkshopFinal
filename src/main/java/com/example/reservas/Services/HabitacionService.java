package com.example.reservas.Services;

import com.example.reservas.DTO.HabitacionDTO;
import com.example.reservas.Exceptions.InvalidStatementException;
import com.example.reservas.Models.Habitacion;
import com.example.reservas.Repositories.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository){ this.habitacionRepository = habitacionRepository;}

    public HabitacionDTO crear(HabitacionDTO habitacionDTO){
        if(habitacionDTO.getTipoHabitacion()==null){
            throw new InvalidStatementException("Es necesario el tipo de habitacion estandar o premium");
        } else if (habitacionDTO.getPrecioBase()==null) {
            throw new InvalidStatementException("precio base para la habitacion es necesario.");
        } else if (habitacionDTO.getNumero()==null) {
            throw new InvalidStatementException("Falta numero de la habitacion");
        }
        Habitacion habitacion = new Habitacion(habitacionDTO.getNumero(), habitacionDTO.getTipoHabitacion(), habitacionDTO.getPrecioBase());
        this.habitacionRepository.save(habitacion);
        return  habitacionDTO;
    }

    public void crearHabitaciones(){
        this.habitacionRepository.save(new Habitacion(55,"premium", 5000));
        this.habitacionRepository.save(new Habitacion(56,"premium", 5000));
        this.habitacionRepository.save(new Habitacion(57,"premium", 5000));
        this.habitacionRepository.save(new Habitacion(58,"premium", 5000));
        this.habitacionRepository.save(new Habitacion(59,"premium", 5000));
        this.habitacionRepository.save(new Habitacion(60,"estandar", 5000));
        this.habitacionRepository.save(new Habitacion(61,"estandar", 5000));
        this.habitacionRepository.save(new Habitacion(62,"estandar", 5000));
        this.habitacionRepository.save(new Habitacion(63,"estandar", 5000));
        this.habitacionRepository.save(new Habitacion(64,"estandar", 5000));
    }

}
