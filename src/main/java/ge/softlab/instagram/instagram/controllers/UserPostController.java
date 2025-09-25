package ge.softlab.instagram.instagram.controllers;

import ge.softlab.instagram.instagram.entities.Post;
import ge.softlab.instagram.instagram.services.UserPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class UserPostController {

    private final UserPostService userpostService;

    @PostMapping("/upload")
    public ResponseEntity<Post> createPost(
            @RequestParam("userId") Long userId,
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "caption", required = false) String caption) throws Exception {
        Post post = userpostService.createPost(userId, file, caption);
        return ResponseEntity.ok(post);
    }
}
