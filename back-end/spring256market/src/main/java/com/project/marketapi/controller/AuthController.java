package com.project.marketapi.controller;

import com.project.marketapi.services.UserService;
import com.project.marketapi.services.impl.UserDetailsImpl;
import com.project.marketapi.services.RoleService;
import com.project.marketapi.model.ERole;
import com.project.marketapi.model.Role;
import com.project.marketapi.model.User;
import com.project.marketapi.payload.request.LoginRequest;
import com.project.marketapi.payload.request.SignupRequest;
import com.project.marketapi.payload.response.JwtResponse;
import com.project.marketapi.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Usuario ya existente!");
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        System.out.println(strRoles);

        if (strRoles == null) {
            Role userRole = roleService.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: No se encuentra dicho Rol."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    /*
                    Beware! the switch statement comparison is case sentitive
                    Be very very sure about how you declared the role string,
                    otherwise new user becomes default case
                    You can check this comparing role_id in the 'user_role' table with 'roles' table
                    */
                    case "ADMIN":
                        Role adminRole = roleService.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra dicho Rol."));
                        roles.add(adminRole);

                        break;
                    default:
                        Role userRole = roleService.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra dicho Rol."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userService.save(user);

        return ResponseEntity.ok("Usuario Registrado!");
    }

}