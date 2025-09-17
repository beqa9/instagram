package ge.softlab.instagram.instagram.repositories;

import ge.softlab.instagram.instagram.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {}

