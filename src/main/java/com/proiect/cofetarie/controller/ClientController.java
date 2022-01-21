package com.proiect.cofetarie.controller;

import com.proiect.cofetarie.exception.general.InvalidUpdateRequestException;
import com.proiect.cofetarie.model.Client;
import com.proiect.cofetarie.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/new")
    public ResponseEntity<Client> saveClient(@RequestBody Client client,
                                            @RequestParam int deliveryAddressID) {
        return ResponseEntity.ok().body(clientService.save(client, deliveryAddressID));
    }

    @GetMapping()
    public List<Client> get(@RequestParam(required = false) String clientName) {
        return clientService.get(clientName);
    }

    @GetMapping("city")
    public List<Client> getByCity(@RequestParam(required = false) String city) {
        return clientService.getByCity(city);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Client> update(
            @PathVariable long id,
            @Valid
            @RequestBody Client request
    ) {

        if (id != request.getClientID()) {
            throw new InvalidUpdateRequestException();
        }

        return ResponseEntity.ok(clientService.update(request));
    }

    @DeleteMapping("/removed/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return ResponseEntity.ok().body(clientService.delete(id));
    }
}
