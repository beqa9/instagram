package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Like;

public interface LikeService {
    Like likePost(Long userId, Long postId);
    void unlikePost(Long userId, Long postId);
}
