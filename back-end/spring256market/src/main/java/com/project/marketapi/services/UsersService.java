package com.project.marketapi.services;

import java.util.List;

import com.project.marketapi.model.Users;
import com.project.marketapi.payload.UsersRequest;

import org.springframework.http.ResponseEntity;

public interface UsersService {
    // Bring partial data from payload - do not interact directly with table
    ResponseEntity<List<Users>> listUsers();

    // CRUD
    ResponseEntity<Users> createUsers(UsersRequest newUsersRequest);
    ResponseEntity<Users> readUsers(int id);
    ResponseEntity<Users> updateUsers(int id, UsersRequest newUsersRequest);
    ResponseEntity<Users> deleteUsers(int id);
}
