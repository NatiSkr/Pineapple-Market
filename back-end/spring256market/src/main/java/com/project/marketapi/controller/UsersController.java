package com.project.marketapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.marketapi.model.Users;
import com.project.marketapi.payload.UsersRequest;
import com.project.marketapi.services.UsersService;

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

public class UsersController {

    // INTERNAL TESTING OF INTERFACE

    // Point to interface
    @Autowired
    private UsersService usersService;

    // LIST
    @GetMapping(value="/users/all")
    public ResponseEntity<List<Users>> listUsers(){
        return usersService.listUsers();
    }

   // CREATE
   @PostMapping(value="/users")
   public ResponseEntity<Users> createUsers(@Valid @RequestBody UsersRequest newUsersRequest) {
       return usersService.createUsers(newUsersRequest);
   }
   
   // READ
   @GetMapping(value="/users/{id}")
   public ResponseEntity<Users> readUsers(@PathVariable("id")int id) {
       return usersService.readUsers(id);
   }

   // UPDATE
   @PutMapping(value="/users/{id}")
   public ResponseEntity<Users> updateUsers(@PathVariable("id") int id, @RequestBody UsersRequest newUsersRequest) {
       return usersService.updateUsers(id, newUsersRequest);
   }

   // DELETE
   @DeleteMapping(value="/users/{id}")
   public ResponseEntity<Users> deleteUsers(@PathVariable("id") int id) {
       return usersService.deleteUsers(id);
   }

    

}
