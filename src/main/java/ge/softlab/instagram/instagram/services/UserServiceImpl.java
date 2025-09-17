package ge.softlab.instagram.instagram.services;


import ge.softlab.instagram.instagram.entities.User;
import ge.softlab.instagram.instagram.models.CreateUserRequest;
import ge.softlab.instagram.instagram.models.UpdateUserRequest;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findByDeletedFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .filter(u -> !u.isDeleted())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Override
    @Transactional
    public User registerUser(CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setBio(request.bio());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(Long id, UpdateUserRequest request) {
        User user = getUserById(id);
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setBio(request.bio());
        user.setProfileImageUrl(request.profileImageUrl());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = getUserById(id);
        user.setDeleted(true);
        userRepository.save(user);
    }
}