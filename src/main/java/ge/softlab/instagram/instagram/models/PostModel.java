package ge.softlab.instagram.instagram.models;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record PostModel(
        Long id,
        Long userId,
        String caption,
        String imageUrl,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {}