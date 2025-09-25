package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.User;
import ge.softlab.instagram.instagram.minio.MinioService;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final MinioService minioService;
    private final UserRepository userRepository;

    public String uploadProfileImage(Long userId, MultipartFile file) throws Exception {
        User user = userRepository.findById(userId).orElseThrow();

        String objectName = minioService.uploadFile(file);
        String imageUrl = minioService.getFileUrl(objectName);

        user.setProfileImageUrl(imageUrl);
        userRepository.save(user);

        return imageUrl;
    }
}
