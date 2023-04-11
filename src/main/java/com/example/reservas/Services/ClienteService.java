package com.example.reservas.Services;

import com.example.reservas.DTO.ClienteDTO;
import com.example.reservas.Exceptions.InvalidStatementException;
import com.example.reservas.Models.Cliente;
import com.example.reservas.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO crear(ClienteDTO clienteDTO){
        if(clienteDTO.getNombre()==null){
            throw new InvalidStatementException("Se requiere el nombre");
        } else if(clienteDTO.getApellido()==null){
            throw new InvalidStatementException("Se requiere el apellido");
        } else if(clienteDTO.getCedula()==null){
            throw new InvalidStatementException("Se requiere una identificacion valida");
        }
        UUID contrasena = UUID.randomUUID();
        Cliente cliente = new Cliente(
                clienteDTO.getNombre(),
                clienteDTO.getApellido(),
                clienteDTO.getCedula(),
                clienteDTO.getDireccion(),
                clienteDTO.getEdad(),
                clienteDTO.getCorreo(),
                "si",
                contrasena.toString()
        );
        this.clienteRepository.save(cliente);
        return clienteDTO;
    }

    public void crearClientes(){
        UUID contrasena = UUID.randomUUID();
        this.clienteRepository.save(new Cliente("enrique","pinzon",123,"calle 1E",23,"correo@gmail.com","si",contrasena.toString()));
        this.clienteRepository.save(new Cliente("andres","serrano",334,"calle 1E",23,"correo@gmail.com","si",contrasena.toString()));
        this.clienteRepository.save(new Cliente("sara","restrepo",675,"calle 1E",23,"correo@gmail.com","si",contrasena.toString()));
        this.clienteRepository.save(new Cliente("sofia","franco",112,"calle 1E",23,"correo@gmail.com","si",contrasena.toString()));
        this.clienteRepository.save(new Cliente("carlos","mancuso",333,"calle 1E",23,"correo@gmail.com","si",contrasena.toString()));
        this.clienteRepository.save(new Cliente("sandra","rodriguez",368,"calle 1E",23,"correo@gmail.com","si",contrasena.toString()));
    }
}
