package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Follow;

import java.util.List;

public interface FollowService {
    Follow followUser(Follow follow);
    void unfollowUser(Long followId);
    List<Follow> getFollowers(Long userId);
    List<Follow> getFollowing(Long userId);
}