package ge.softlab.instagram.instagram.models;

public record CreateUserRequest(
        String username,
        String email,
        String password,
        String bio
) {}
