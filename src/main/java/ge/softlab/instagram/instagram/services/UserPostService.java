package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Post;
import ge.softlab.instagram.instagram.entities.User;
import ge.softlab.instagram.instagram.minio.MinioService;
import ge.softlab.instagram.instagram.repositories.PostRepository;
import ge.softlab.instagram.instagram.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserPostService {

    private final MinioService minioService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post createPost(Long userId, MultipartFile file, String caption) throws Exception {
        User user = userRepository.findById(userId).orElseThrow();

        String objectName = minioService.uploadFile(file);
        String imageUrl = minioService.getFileUrl(objectName);

        Post post = new Post();
        post.setUser(user);
        post.setCaption(caption);
        post.setImageUrl(imageUrl);

        return postRepository.save(post);
    }
}
