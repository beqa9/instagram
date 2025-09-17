package ge.softlab.instagram.instagram.models;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record LikeModel(
        Long id,
        Long userId,
        Long postId,
        OffsetDateTime createdAt
) {}
