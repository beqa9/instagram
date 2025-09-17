package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.User;
import ge.softlab.instagram.instagram.models.UserModel;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.findByIsDeletedFalse();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .filter(u -> !u.isDeleted())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public User addUserByModel(UserModel userModel) {
        User user = new User();
        user.setUsername(userModel.username());
        user.setEmail(userModel.email());
        user.setPassword(userModel.password());
        user.setProfileImageUrl(userModel.profileImageUrl());
        user.setBio(userModel.bio());
        return userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public User updateUserByIdAndModel(Long id, UserModel userModel) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        existingUser.setUsername(userModel.username());
        existingUser.setEmail(userModel.email());
        existingUser.setPassword(userModel.password());
        existingUser.setProfileImageUrl(userModel.profileImageUrl());
        existingUser.setBio(userModel.bio());

        return userRepository.save(existingUser);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserById(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        existingUser.setDeleted(true);
        userRepository.save(existingUser);
    }
}