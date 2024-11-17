package br.com.ecosage.service;

import br.com.ecosage.model.User;
import br.com.ecosage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public ResponseEntity<?> getUsersList() {
        try {
            List<User> users = userRepository.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get Users: " + e);
        }
    }

    public ResponseEntity<?> createUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User createdUser = userRepository.save(user);
            return ResponseEntity.ok(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to create User: " + e);
        }
    }


    public ResponseEntity<?> getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User NOT FOUND, ID: " + id);
        }
        try {
            return ResponseEntity.ok(user.get());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get User, ID: " + id);
        }
    }

    public ResponseEntity<?> editUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User NOT FOUND, ID: " + id);
        }
        try {
            user.setId(id);
            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to edit User, ID: " + id);
        }
    }

    public ResponseEntity<?> deleteUser(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User NOT FOUND, ID: " + id);
        }
        try {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted, ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to delete User, ID: " + id);
        }
    }
}
