package com.project.marketapi.services;

import java.util.List;

import com.project.marketapi.model.User;
import com.project.marketapi.payload.request.UserRequest;

import org.springframework.http.ResponseEntity;

public interface UserCRUDService {
    // Bring partial data from payload - do not interact directly with table
    ResponseEntity<List<User>> listUser();

    // CRUD
    ResponseEntity<User> createUser(UserRequest newUserRequest);
    ResponseEntity<User> readUser(int id);
    ResponseEntity<User> updateUser(int id, UserRequest newUserRequest);
    ResponseEntity<User> deleteUser(int id);
}
