package com.example.reservas;

import com.example.reservas.DTO.ClienteDTO;
import com.example.reservas.Models.Cliente;
import com.example.reservas.Repositories.ClienteRepository;
import com.example.reservas.Services.ClienteService;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.mock;

public class ClienteServiceTest {
    ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @Before
    public void setUp(){
        this.clienteRepository = mock(ClienteRepository.class);
        this.clienteService = new ClienteService(clienteRepository);
    }

    @Test(expected = RuntimeException.class)
    public void testCrearClienteConNombreNull(){
        //Arrange, creamos escenario de prueba
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(null);
        clienteDTO.setApellido("Pinzon");
        //act: ejecutamos el metodo que estamos probando en service.
        clienteService.crear(clienteDTO);
        //assert
        //Verificamos el resultados, esperamos una excepcion RuntimeException.
    }
    @Test(expected = RuntimeException.class)
    public void testCrearClienteConApellidoNull(){
        //Arrange
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre("enrique");
        clienteDTO.setApellido(null);
        //act
        clienteService.crear(clienteDTO);
        //assert
    }
    @Test(expected = RuntimeException.class)
    public void testCrearClienteConNombreyApellidoNull(){
        //Arrange
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(null);
        clienteDTO.setApellido(null);
        //act
        clienteService.crear(clienteDTO);
        //assert

    }
    @Test
    public void testCrearClienteExitoso(){
        //Arrange
        ClienteDTO clienteDTO = new ClienteDTO("Enrique", "Pinzon",123,"correo@gmail.com", "Calle 1E ", 23);
        //act
        ClienteDTO result =  clienteService.crear(clienteDTO);
        //assert
        Assertions.assertNotNull(result); //verificamos que el resultado no se nulo;
        Assertions.assertEquals(123, result.getCedula()); //verificamos cedula sea la esperada
        Assertions.assertEquals("Enrique", result.getNombre()); // Verificar que el nombre sea el esperado
        Assertions.assertEquals("Pinzon", result.getApellido()); // Verificar que el apellido sea el esperado
        Assertions.assertEquals("Calle 1E # 17-75", result.getDireccion()); // Verificar que la direccion sea la esperada;
        Assertions.assertEquals("23", result.getEdad()); // Verificar que la edad sea la esperada;
        Assertions.assertEquals("correo@gmail.com", result.getCorreo()); // Verificar que el correo sea la esperado;

    }



}
