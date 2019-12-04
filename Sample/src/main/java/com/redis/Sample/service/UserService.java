package com.redis.Sample.service;

import com.redis.Sample.config.CacheConfigurationProperties;
import com.redis.Sample.model.User;
import com.redis.Sample.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserService {
    @Autowired
    UserRepositories repositories;
    @Autowired
    CacheConfigurationProperties properties;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        user.setTimeToLive(properties.getTimeoutSeconds());
        repositories.save(user);
        System.out.println("saved");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = repositories.findAll();
        System.out.println("reading");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> deleteAllUsers() {
        repositories.deleteAll();
        System.out.println("deleted all ");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/clear/{Id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        repositories.deleteById(id);
        System.out.println("deleted id ");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
