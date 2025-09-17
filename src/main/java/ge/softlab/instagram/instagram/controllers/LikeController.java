package ge.softlab.instagram.instagram.controllers;

import ge.softlab.instagram.instagram.entities.Like;
import ge.softlab.instagram.instagram.mappers.LikeMapper;
import ge.softlab.instagram.instagram.models.LikeModel;
import ge.softlab.instagram.instagram.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;
    private final LikeMapper likeMapper;

    @GetMapping("/post/{postId}")
    public List<LikeModel> getLikesByPost(@PathVariable Long postId) {
        return likeMapper.toModelList(likeService.getLikesByPost(postId));
    }

    @GetMapping("/user/{userId}")
    public List<LikeModel> getLikesByUser(@PathVariable Long userId) {
        return likeMapper.toModelList(likeService.getLikesByUser(userId));
    }

    @PostMapping
    public LikeModel likePost(@RequestBody Like like) {
        return likeMapper.toModel(likeService.likePost(like));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> unlikePost(@PathVariable Long id) {
        likeService.unlikePost(id);
        return ResponseEntity.ok("Unliked successfully");
    }
}