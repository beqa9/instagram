package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByPost(Long postId);
    Comment addComment(Comment comment);
    Comment replyToComment(Long parentId, Comment reply);
    void deleteComment(Long commentId);
}
