package com.example.reservas.Controllers;

import com.example.reservas.DTO.ClienteDTO;
import com.example.reservas.Models.Cliente;
import com.example.reservas.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService){this.clienteService=clienteService;}

    @PostMapping("/cliente")
    public ClienteDTO crearCliente(@RequestBody ClienteDTO clienteDTO){
        return this.clienteService.crear(clienteDTO);

    }

    @PostMapping("/clientes")
    public String crearCliente(){
        this.clienteService.crearClientes();
        return "creando clientes";
    }

}
