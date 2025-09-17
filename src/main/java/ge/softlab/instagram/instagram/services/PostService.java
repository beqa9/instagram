package ge.softlab.instagram.instagram.services;

import ge.softlab.instagram.instagram.entities.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post createPost(Post post);
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}