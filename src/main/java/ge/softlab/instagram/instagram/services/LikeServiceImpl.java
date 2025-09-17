package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Like;
import ge.softlab.instagram.instagram.repositories.LikeRepository;
import ge.softlab.instagram.instagram.repositories.PostRepository;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository repository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public Like likePost(Long userId, Long postId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        var post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Like like = new Like();
        like.setUser(user);
        like.setPost(post);

        return repository.save(like);
    }

    @Override
    public void unlikePost(Long userId, Long postId) {
        repository.findAll().stream()
                .filter(l -> l.getUser().getId().equals(userId) && l.getPost().getId().equals(postId))
                .findFirst()
                .ifPresent(repository::delete);
    }
}
