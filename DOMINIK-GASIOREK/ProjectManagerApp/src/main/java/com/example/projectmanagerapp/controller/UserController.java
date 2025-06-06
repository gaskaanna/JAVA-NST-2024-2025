package com.example.projectmanagerapp.controller;

import com.example.projectmanagerapp.entity.User;
import com.example.projectmanagerapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name="User Controller", description="Users management")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary="Get all users", description="Receives all users stored")
    @GetMapping("/get-all-users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @Operation(summary="Get user by id", description="Receives user with provided id")
    @GetMapping("/get-user/{id}")
    public Optional<User> getByID(
            @Parameter(description="User id") @PathVariable Long id
    ) {
        return userService.getByID(id);
    }

    @Operation(summary="Creates new user", description="Creates new user")
    @PostMapping("/create-user")
    public User create(@RequestBody User newUser) {
        return userService.create(newUser);
    }

    @Operation(summary="Updates existing user", description="Updates a user with the given id")
    @PutMapping("/update-user/{id}")
    public Optional<User> update(
            @Parameter(description = "User id") @PathVariable Long id,
            @RequestBody User updatedUser
    ) {
        return userService.update(id, updatedUser);
    }

    @Operation(summary="Deletes user by id", description="Deletes the user with the given id")
    @DeleteMapping("/delete-user/{id}")
    public void delete(
            @Parameter(description = "User id") @PathVariable Long id
    ) {
        userService.delete(id);
    }
}
