package com.project.marketapi.services.impl;

import java.util.List;
import java.util.Optional;

import com.project.marketapi.model.User;
import com.project.marketapi.payload.request.UserRequest;
import com.project.marketapi.repository.UserRepository;
import com.project.marketapi.services.UserCRUDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserCRUDService{

    @Autowired
    private UserRepository userRepository;

    // LIST
    @Override
    public ResponseEntity<List<User>> listUser() {
        try {
            List<User> user = userRepository.findAll();
            if (user.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // CREATE
    @Override
    public ResponseEntity<User> createUser(UserRequest newUserRequest) {
        User user = new User();
        user.setUsername(newUserRequest.getUsername());
        user.setPassword(newUserRequest.getPassword());
        user.setFirstName(newUserRequest.getFirstName());
        user.setLastNameP(newUserRequest.getLastNameP());
        user.setLastNameM(newUserRequest.getLastNameM());
        User newUser = userRepository.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

        // READ
    @Override
    public ResponseEntity<User> readUser(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @Override
    public ResponseEntity<User> updateUser(int id, UserRequest newUserRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            User _user = user.get();
            _user.setUsername(newUserRequest.getUsername());
            _user.setPassword(newUserRequest.getPassword());
            _user.setFirstName(newUserRequest.getFirstName());
            _user.setLastNameP(newUserRequest.getLastNameP());
            _user.setLastNameM(newUserRequest.getLastNameM());
            User updatedProduct = userRepository.save(_user);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // DELETE
    @Override
    public ResponseEntity<User> deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
