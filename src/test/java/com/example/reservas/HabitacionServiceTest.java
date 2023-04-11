package com.example.reservas;

import com.example.reservas.Models.Habitacion;
import com.example.reservas.Repositories.HabitacionRepository;
import com.example.reservas.Services.HabitacionService;
import com.example.reservas.Services.ReservaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;

public class HabitacionServiceTest {
    HabitacionRepository habitacionRepository;
    private HabitacionService habitacionService;


    @Before
    public void setUp(){
        this.habitacionRepository = mock(HabitacionRepository.class);
        this.habitacionService = new HabitacionService(habitacionRepository);
    }

}
