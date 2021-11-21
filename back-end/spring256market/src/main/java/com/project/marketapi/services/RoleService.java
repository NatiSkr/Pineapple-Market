package com.project.marketapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.project.marketapi.model.ERole;
import com.project.marketapi.model.Role;
import com.project.marketapi.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository dao;

    public Optional<Role> findByName(ERole name){
        System.out.println(dao.findAll());
        return dao.findByName(name);
    }
}
