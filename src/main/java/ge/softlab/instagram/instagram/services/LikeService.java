package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Like;

import java.util.List;

public interface LikeService {
    List<Like> getLikesByPost(Long postId);
    List<Like> getLikesByUser(Long userId);
    Like likePost(Like like);
    void unlikePost(Long likeId);
}
