package ge.softlab.instagram.instagram.models;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record FollowModel(
        Long id,
        Long followerId,
        Long followingId,
        OffsetDateTime createdAt
) {}
