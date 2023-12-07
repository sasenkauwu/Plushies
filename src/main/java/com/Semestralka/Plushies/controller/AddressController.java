package com.Semestralka.Plushies.controller;

import com.Semestralka.Plushies.entity.Address;
import com.Semestralka.Plushies.request.AddressSaveRequest;
import com.Semestralka.Plushies.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable UUID id) {

        return addressService.getAddress(id);
    }

    @PostMapping("/save")
    public void saveAddress(@RequestBody AddressSaveRequest request) {
        addressService.saveAddress(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
    }

    @PutMapping("update/{id}")
    public void updateAddress(@PathVariable UUID id) {
        addressService.updateAddress(id);
    }
}
