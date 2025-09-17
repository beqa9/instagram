package ge.softlab.instagram.instagram.controllers;

import ge.softlab.instagram.instagram.entities.Post;
import ge.softlab.instagram.instagram.mappers.PostMapper;
import ge.softlab.instagram.instagram.models.PostModel;
import ge.softlab.instagram.instagram.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping
    public List<PostModel> getAllPosts() {
        return postMapper.toModelList(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public PostModel getPostById(@PathVariable Long id) {
        return postMapper.toModel(postService.getPostById(id));
    }

    @PostMapping
    public PostModel createPost(@RequestBody Post post) {
        return postMapper.toModel(postService.createPost(post));
    }

    @PutMapping("/{id}")
    public PostModel updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postMapper.toModel(postService.updatePost(id, post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("Post deleted successfully");
    }
}