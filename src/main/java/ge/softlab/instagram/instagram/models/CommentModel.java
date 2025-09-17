package ge.softlab.instagram.instagram.models;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record CommentModel(
        Long id,
        Long userId,
        Long postId,
        Long parentId,
        String text,
        OffsetDateTime createdAt
) {}
