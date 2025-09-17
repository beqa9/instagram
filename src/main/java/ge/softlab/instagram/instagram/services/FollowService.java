package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Follow;

public interface FollowService {
    Follow follow(Long followerId, Long followingId);
    void unfollow(Long followerId, Long followingId);
}
