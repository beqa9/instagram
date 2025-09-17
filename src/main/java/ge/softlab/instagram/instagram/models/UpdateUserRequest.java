package ge.softlab.instagram.instagram.models;

public record UpdateUserRequest(
        String username,
        String email,
        String bio,
        String profileImageUrl
) {}
