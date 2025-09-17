package ge.softlab.instagram.instagram.models;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record UserModel(
        Long id,
        String username,
        String email,
        String profileImageUrl,
        String bio,
        OffsetDateTime createdAt
) {}