package com.proiect.cofetarie.mapper;

import com.proiect.cofetarie.dto.cake.CreateCakeDto;
import com.proiect.cofetarie.dto.cake.UpdateCakeDto;
import com.proiect.cofetarie.model.Cake;
import org.springframework.stereotype.Component;

@Component
public class CakeMapper {
    public Cake createCake(CreateCakeDto request) {
        return new Cake(request.getCakeName(), request.getShortDescription(), request.getPrice(), request.getWeight());
    }

    public Cake createCake(CreateCakeDto request, int cakeCategoryID, int orderID) {
        return new Cake(request.getCakeName(), request.getShortDescription(), request.getPrice(), request.getWeight());
    }

    public Cake updateCake(UpdateCakeDto request) {
        return new Cake(request.getId(), request.getCakeName(), request.getShortDescription(), request.getPrice(), request.getWeight());
    }
}
