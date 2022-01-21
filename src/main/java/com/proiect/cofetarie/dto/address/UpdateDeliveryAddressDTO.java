package com.proiect.cofetarie.dto.address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateDeliveryAddressDTO extends CreateNewDeliveryAddressDTO {
    @NotNull
    private int id;

    public UpdateDeliveryAddressDTO(@NotNull int id, @NotBlank @Size(max = 100) String country, @NotBlank @Size(max = 100) String region, @NotBlank @Size(max = 100) String city, @NotBlank @Size(max = 100) String street, @NotNull int streetNumber, int floorNumber, int apartmentNumber) {
        super(country, region, city, street, streetNumber, floorNumber, apartmentNumber);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
