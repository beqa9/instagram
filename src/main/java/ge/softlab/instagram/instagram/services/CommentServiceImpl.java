package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Comment;
import ge.softlab.instagram.instagram.repositories.CommentRepository;
import ge.softlab.instagram.instagram.repositories.PostRepository;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public Comment addComment(Comment comment) {
        postRepository.findById(comment.getPost().getId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        userRepository.findById(comment.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return repository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPost(Long postId) {
        return repository.findAll()
                .stream()
                .filter(c -> c.getPost().getId().equals(postId))
                .toList();
    }
}
