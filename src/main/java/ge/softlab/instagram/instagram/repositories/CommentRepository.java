package ge.softlab.instagram.instagram.repositories;

import ge.softlab.instagram.instagram.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}

