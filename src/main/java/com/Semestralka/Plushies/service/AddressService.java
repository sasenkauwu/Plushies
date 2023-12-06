package com.Semestralka.Plushies.service;

import com.Semestralka.Plushies.entity.Address;
import com.Semestralka.Plushies.entity.User;
import com.Semestralka.Plushies.repository.AddressRepository;
import com.Semestralka.Plushies.request.AddressSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    public Address getAddress(UUID id) {
        return addressRepository.findById(id).get();
    }

    public void saveAddress(AddressSaveRequest request) {
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setZipCode(request.getZipCode());
        address.setCountry(request.getCountry());

        addressRepository.save(address);
    }

    public void deleteAddress(UUID id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Product does not exist!");
        } else {
            addressRepository.deleteById(id);
        }
    }

    public void updateAddress(UUID id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Product does not exist!");
        } else {
            //idk
        }
    }
}
