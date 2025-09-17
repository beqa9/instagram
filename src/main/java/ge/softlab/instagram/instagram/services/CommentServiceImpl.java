package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Comment;
import ge.softlab.instagram.instagram.repositories.CommentRepository;
import ge.softlab.instagram.instagram.repositories.PostRepository;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Comment> getCommentsByPost(Long postId) {
        return commentRepository.findByPostIdAndDeletedFalse(postId);
    }

    @Override
    @Transactional
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public Comment replyToComment(Long parentId, Comment reply) {
        Comment parent = commentRepository.findById(parentId).orElseThrow();
        reply.setParent(parent);
        reply.setPost(parent.getPost());
        return commentRepository.save(reply);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.setDeleted(true);
        commentRepository.save(comment);
    }
}
