package com.example.spring256market.controller;

import java.util.List;

import com.example.spring256market.model.Users;
import com.example.spring256market.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/users") // handle only /api requests

public class UsersController {

    // INTERNAL TESTING OF INTERFACE

    // Point to interface
    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    

}
