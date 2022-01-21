package com.proiect.cofetarie.controller;

import com.proiect.cofetarie.dto.address.CreateNewDeliveryAddressDTO;
import com.proiect.cofetarie.dto.address.UpdateDeliveryAddressDTO;
import com.proiect.cofetarie.exception.general.InvalidUpdateRequestException;
import com.proiect.cofetarie.mapper.DeliveryAddressMapper;
import com.proiect.cofetarie.model.DeliveryAddress;
import com.proiect.cofetarie.service.DeliveryAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/delivery-address")
@Validated
public class DeliveryAddressController {
    private DeliveryAddressService deliveryAddressService;
    private DeliveryAddressMapper deliveryAddressMapper;

    public DeliveryAddressController(DeliveryAddressService deliveryAddressService, DeliveryAddressMapper deliveryAddressMapper) {
        this.deliveryAddressService = deliveryAddressService;
        this.deliveryAddressMapper = deliveryAddressMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<DeliveryAddress> create(
            @Valid
            @RequestBody CreateNewDeliveryAddressDTO request) {
        DeliveryAddress deliveryAddress = deliveryAddressService.create(deliveryAddressMapper.create(request));
        return ResponseEntity.created(URI.create("/delivery-address/new" + deliveryAddress.getDeliveryAddressID())).body(deliveryAddress);
    }

    @GetMapping()
    public List<DeliveryAddress> get(@RequestParam(required = false) String city,
                                     @RequestParam(required = false) String region) {
        return deliveryAddressService.get(city, region);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DeliveryAddress> update(
            @PathVariable long id,
            @Valid
            @RequestBody UpdateDeliveryAddressDTO request
    ) {

        if (id != request.getId()) {
            throw new InvalidUpdateRequestException();
        }

        return ResponseEntity.ok(deliveryAddressService.update(deliveryAddressMapper.update(request)));
    }

    @DeleteMapping("/removed/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return ResponseEntity.ok().body(deliveryAddressService.delete(id));
    }
}
