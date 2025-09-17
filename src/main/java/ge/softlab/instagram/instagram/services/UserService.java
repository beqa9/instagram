package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.User;
import ge.softlab.instagram.instagram.models.UserModel;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User addUserByModel(UserModel userModel);

    User updateUserByIdAndModel(Long id, UserModel userModel);

    void deleteUserById(Long id);
}