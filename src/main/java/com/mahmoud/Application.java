package com.mahmoud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

    private final UserRepository repo;

    public Application(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home() {
        return "Hello Mahmoud 🚀";
    }

    @GetMapping("/boom")
    public String boom() {
        throw new RuntimeException("Test error");
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return repo.save(user);
    }

    @GetMapping("/users")
    public List<User> all() {
        return repo.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}