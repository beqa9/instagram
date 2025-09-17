package ge.softlab.instagram.instagram.models;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
public record CommentModel(
        Long id,
        Long userId,
        Long postId,
        Long parentId,
        String text,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt,
        List<CommentModel> replies
) {}
