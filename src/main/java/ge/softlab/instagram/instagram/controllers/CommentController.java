package ge.softlab.instagram.instagram.controllers;

import ge.softlab.instagram.instagram.entities.Comment;
import ge.softlab.instagram.instagram.mappers.CommentMapper;
import ge.softlab.instagram.instagram.models.CommentModel;
import ge.softlab.instagram.instagram.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @GetMapping("/post/{postId}")
    public List<CommentModel> getCommentsByPost(@PathVariable Long postId) {
        return commentMapper.toModelList(commentService.getCommentsByPost(postId));
    }

    @PostMapping
    public CommentModel addComment(@RequestBody Comment comment) {
        return commentMapper.toModel(commentService.addComment(comment));
    }

    @PostMapping("/reply/{parentId}")
    public CommentModel replyToComment(@PathVariable Long parentId, @RequestBody Comment reply) {
        return commentMapper.toModel(commentService.replyToComment(parentId, reply));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok("Comment deleted successfully");
    }
}
