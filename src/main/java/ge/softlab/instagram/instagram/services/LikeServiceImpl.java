package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Like;
import ge.softlab.instagram.instagram.repositories.LikeRepository;
import ge.softlab.instagram.instagram.repositories.PostRepository;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Like> getLikesByPost(Long postId) {
        return likeRepository.findByPostIdAndDeletedFalse(postId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Like> getLikesByUser(Long userId) {
        return likeRepository.findByUserIdAndDeletedFalse(userId);
    }

    @Override
    @Transactional
    public Like likePost(Like like) {
        return likeRepository.save(like);
    }

    @Override
    @Transactional
    public void unlikePost(Long likeId) {
        Like like = likeRepository.findById(likeId).orElseThrow();
        like.setDeleted(true);
        likeRepository.save(like);
    }
}