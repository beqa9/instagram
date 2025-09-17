package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post getPost(Long id);
    List<Post> getUserPosts(Long userId);
}
