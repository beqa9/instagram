package ge.softlab.instagram.instagram.controllers;

import ge.softlab.instagram.instagram.entities.Follow;
import ge.softlab.instagram.instagram.mappers.FollowMapper;
import ge.softlab.instagram.instagram.models.FollowModel;
import ge.softlab.instagram.instagram.services.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follows")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;
    private final FollowMapper followMapper;

    @GetMapping("/followers/{userId}")
    public List<FollowModel> getFollowers(@PathVariable Long userId) {
        return followMapper.toModelList(followService.getFollowers(userId));
    }

    @GetMapping("/following/{userId}")
    public List<FollowModel> getFollowing(@PathVariable Long userId) {
        return followMapper.toModelList(followService.getFollowing(userId));
    }

    @PostMapping
    public FollowModel followUser(@RequestBody Follow follow) {
        return followMapper.toModel(followService.followUser(follow));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> unfollowUser(@PathVariable Long id) {
        followService.unfollowUser(id);
        return ResponseEntity.ok("Unfollowed successfully");
    }
}
