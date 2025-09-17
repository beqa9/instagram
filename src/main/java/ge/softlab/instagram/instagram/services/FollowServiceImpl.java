package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Follow;
import ge.softlab.instagram.instagram.repositories.FollowRepository;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    @Override
    @Transactional
    public Follow followUser(Follow follow) {
        return followRepository.save(follow);
    }

    @Override
    @Transactional
    public void unfollowUser(Long followId) {
        followRepository.deleteById(followId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Follow> getFollowers(Long userId) {
        return followRepository.findByFollowingId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Follow> getFollowing(Long userId) {
        return followRepository.findByFollowerId(userId);
    }
}
