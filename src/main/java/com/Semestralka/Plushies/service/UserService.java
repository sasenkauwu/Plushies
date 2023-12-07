package com.Semestralka.Plushies.service;

import com.Semestralka.Plushies.entity.Address;
import com.Semestralka.Plushies.entity.User;
import com.Semestralka.Plushies.repository.AddressRepository;
import com.Semestralka.Plushies.repository.UserRepository;
import com.Semestralka.Plushies.request.UserLoginRequest;
import com.Semestralka.Plushies.request.UserRegistrationSaveRequest;
import com.Semestralka.Plushies.request.UserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;


    public User getUser(UUID id) {
        return userRepository.findById(id).get();
    }

    public void saveUser(UserSaveRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        //user.setDateOfBirth(request.getDateOfBirth());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        userRepository.save(user);
    }

    public void registerUser(UserRegistrationSaveRequest request) {
        User user = new User();

        user.setName(request.getName());
        user.setSurname(request.getSurname());
        //user.setDateOfBirth(request.getDateOfBirth());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setZipCode(request.getZipCode());
        address.setCountry(request.getCountry());

        user.setAddress(address);
        address.setUser(user);

        addressRepository.save(address);
        userRepository.save(user);
    }

    public boolean loginUser(UserLoginRequest loginRequest) {
        User foundUser = userRepository.findByEmail(loginRequest.getEmail());
        if (foundUser != null && foundUser.getPassword().equals(loginRequest.getPassword())) {
            return true;
        }
        return false;
    }

    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Product does not exist!");
        } else {
            userRepository.deleteById(id);
        }
    }

    public void updateUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Product does not exist!");
        } else {
            //idk
        }
    }
}
