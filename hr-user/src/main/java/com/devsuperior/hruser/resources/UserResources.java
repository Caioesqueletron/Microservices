package com.devsuperior.hruser.resources;

import com.devsuperior.hruser.entites.User;
import com.devsuperior.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserRepository repository;



    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable String id){


        Optional<User> user = repository.findById(Long.parseLong(id));
        return  ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){

        User user = repository.findByEmail(email);
        return  ResponseEntity.ok().body(user);
    }

}

