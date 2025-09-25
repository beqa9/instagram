package ge.softlab.instagram.instagram.controllers;

import ge.softlab.instagram.instagram.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping("/{id}/upload-profile")
    public ResponseEntity<String> uploadProfileImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) throws Exception {
        String url = userProfileService.uploadProfileImage(id, file);
        return ResponseEntity.ok(url);
    }
}
