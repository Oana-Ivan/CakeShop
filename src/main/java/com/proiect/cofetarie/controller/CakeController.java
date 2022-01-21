package com.proiect.cofetarie.controller;

import com.proiect.cofetarie.dto.cake.CreateCakeDto;
import com.proiect.cofetarie.dto.cake.UpdateCakeDto;
import com.proiect.cofetarie.exception.general.InvalidUpdateRequestException;
import com.proiect.cofetarie.mapper.CakeMapper;
import com.proiect.cofetarie.model.Cake;
import com.proiect.cofetarie.service.CakeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cake")
@Validated
public class CakeController {
    private CakeService cakeService;
    private CakeMapper cakeMapper;

    public CakeController(CakeService cakeService, CakeMapper cakeMapper) {
        this.cakeService = cakeService;
        this.cakeMapper = cakeMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Cake> create(
            @Valid
            @RequestBody CreateCakeDto request,
            @RequestParam int cakeCategoryID
//            @RequestParam int orderID
            ) {
        Cake cake = cakeService.create(cakeMapper.createCake(request), cakeCategoryID); //, cakeCategoryID, orderID));
        return ResponseEntity.created(URI.create("/cake/new" + cake.getCakeID())).body(cakeService.create(cake, cakeCategoryID));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Cake> update(
            @PathVariable long id,
            @Valid
            @RequestBody UpdateCakeDto request
            ) {

        if (id != request.getId()) {
            throw new InvalidUpdateRequestException();
        }

        Cake cake = cakeService.update(cakeMapper.updateCake(request));
        return ResponseEntity.ok(cake);
    }
//
//    @GetMapping()
//    public List<Cake> get(@RequestParam(required = false) String name) {
//        return cakeService.getByName(name);
//    }

    @GetMapping()
    public List<Cake> get(@RequestParam(required = false) Double weight,
                          @RequestParam(required = false) Integer price) {
        return cakeService.get(weight, price);
    }

    @GetMapping("/category")
    public List<Cake> get(@RequestParam String categoryName) {
        return cakeService.get(categoryName);
    }

    @DeleteMapping("/removed/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return ResponseEntity.ok().body(cakeService.delete(id));
    }
}
