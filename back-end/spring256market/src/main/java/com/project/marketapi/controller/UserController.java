package com.project.marketapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.marketapi.model.User;
import com.project.marketapi.payload.request.UserRequest;
import com.project.marketapi.services.UserCRUDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // handle only /api requests

public class UserController {

    // INTERNAL TESTING OF INTERFACE

    // Point to interface
    @Autowired
    private UserCRUDService userCRUDService;

    // LIST
    @GetMapping(value="/user/all")
    public ResponseEntity<List<User>> listUser(){
        return userCRUDService.listUser();
    }

   // CREATE
   @PostMapping(value="/user")
   public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest newUserRequest) {
       return userCRUDService.createUser(newUserRequest);
   }
   
   // READ
   @GetMapping(value="/user/{id}")
   public ResponseEntity<User> readUser(@PathVariable("id")int id) {
       return userCRUDService.readUser(id);
   }

   // UPDATE
   @PutMapping(value="/user/{id}")
   public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UserRequest newUserRequest) {
       return userCRUDService.updateUser(id, newUserRequest);
   }

   // DELETE
   @DeleteMapping(value="/user/{id}")
   public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
       return userCRUDService.deleteUser(id);
   }

    

}
