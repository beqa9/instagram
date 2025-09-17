package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    List<Comment> getCommentsByPost(Long postId);
}
