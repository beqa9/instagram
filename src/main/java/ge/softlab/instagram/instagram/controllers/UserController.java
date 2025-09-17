package ge.softlab.instagram.instagram.controllers;

import ge.softlab.instagram.instagram.entities.User;
import ge.softlab.instagram.instagram.mappers.UserMapper;
import ge.softlab.instagram.instagram.models.CreateUserRequest;
import ge.softlab.instagram.instagram.models.UpdateUserRequest;
import ge.softlab.instagram.instagram.models.UserModel;
import ge.softlab.instagram.instagram.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "user-controller", description = "CRUD operations for users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userMapper.toModelList(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        return userMapper.toModel(userService.getUserById(id));
    }

    @PostMapping("/register")
    public UserModel registerUser(@RequestBody CreateUserRequest request) {
        User user = userService.registerUser(request);
        return userMapper.toModel(user);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        User updated = userService.updateUser(id, request);
        return userMapper.toModel(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}