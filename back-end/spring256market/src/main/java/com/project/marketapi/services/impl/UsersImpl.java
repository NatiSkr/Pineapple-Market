package com.project.marketapi.services.impl;

import java.util.List;
import java.util.Optional;

import com.project.marketapi.model.Users;
import com.project.marketapi.payload.UsersRequest;
import com.project.marketapi.repository.UsersRepository;
import com.project.marketapi.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    // LIST
    @Override
    public ResponseEntity<List<Users>> listUsers() {
        try {
            List<Users> users = usersRepository.findAll();
            if (users.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // CREATE
    @Override
    public ResponseEntity<Users> createUsers(UsersRequest newUsersRequest) {
        Users user = new Users();
        user.setIsAdmin(newUsersRequest.getIsAdmin());
        user.setUserName(newUsersRequest.getUserName());
        user.setEmail(newUsersRequest.getEmail());
        user.setPassword(newUsersRequest.getPassword());
        user.setFirstName(newUsersRequest.getFirstName());
        user.setLastNameP(newUsersRequest.getLastNameP());
        user.setLastNameM(newUsersRequest.getLastNameM());
        Users newUsers = usersRepository.save(user);
        return new ResponseEntity<>(newUsers, HttpStatus.CREATED);
    }

        // READ
    @Override
    public ResponseEntity<Users> readUsers(int id) {
        Optional<Users> user = usersRepository.findById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @Override
    public ResponseEntity<Users> updateUsers(int id, UsersRequest newUsersRequest) {
        Optional<Users> user = usersRepository.findById(id);
        if (user.isPresent()){
            Users _user = user.get();
            _user.setIsAdmin(newUsersRequest.getIsAdmin());
            _user.setUserName(newUsersRequest.getUserName());
            Users updatedProduct = usersRepository.save(_user);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // DELETE
    @Override
    public ResponseEntity<Users> deleteUsers(int id) {
        try {
            usersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
