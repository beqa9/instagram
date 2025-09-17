package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.User;
import ge.softlab.instagram.instagram.models.CreateUserRequest;
import ge.softlab.instagram.instagram.models.UpdateUserRequest;
import ge.softlab.instagram.instagram.models.UserModel;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User registerUser(CreateUserRequest request);

    User updateUser(Long id, UpdateUserRequest request);

    void deleteUser(Long id);
}