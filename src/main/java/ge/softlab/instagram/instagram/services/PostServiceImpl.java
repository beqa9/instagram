package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Post;
import ge.softlab.instagram.instagram.repositories.PostRepository;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final UserRepository userRepository;

    @Override
    public Post createPost(Post post) {
        // Ensure user exists
        userRepository.findById(post.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return repository.save(post);
    }

    @Override
    public Post getPost(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public List<Post> getUserPosts(Long userId) {
        return repository.findAll()
                .stream()
                .filter(p -> p.getUser().getId().equals(userId))
                .toList();
    }
}
