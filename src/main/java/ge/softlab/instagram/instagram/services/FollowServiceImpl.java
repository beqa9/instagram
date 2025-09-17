package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Follow;
import ge.softlab.instagram.instagram.repositories.FollowRepository;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepository repository;
    private final UserRepository userRepository;

    @Override
    public Follow follow(Long followerId, Long followingId) {
        var follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));
        var following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("Following not found"));

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);

        return repository.save(follow);
    }

    @Override
    public void unfollow(Long followerId, Long followingId) {
        repository.findAll().stream()
                .filter(f -> f.getFollower().getId().equals(followerId) && f.getFollowing().getId().equals(followingId))
                .findFirst()
                .ifPresent(repository::delete);
    }
}