package com.testing.SpringBootForDeployment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.testing.SpringBootForDeployment.Model.User;
import com.testing.SpringBootForDeployment.Repo.UserRepository;

@RestController
@RequestMapping("/add")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/api/users")
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "User added successfully";
    }
    
    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
