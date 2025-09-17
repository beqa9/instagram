package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Post;
import ge.softlab.instagram.instagram.repositories.PostRepository;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        return postRepository.findByDeletedFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .filter(p -> !p.isDeleted())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
    }

    @Override
    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public Post updatePost(Long id, Post post) {
        Post existing = getPostById(id);
        existing.setCaption(post.getCaption());
        existing.setImageUrl(post.getImageUrl());
        return postRepository.save(existing);
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        Post post = getPostById(id);
        post.setDeleted(true);
        postRepository.save(post);
    }
}
