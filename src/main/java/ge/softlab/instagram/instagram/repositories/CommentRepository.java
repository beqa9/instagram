package ge.softlab.instagram.instagram.repositories;

import ge.softlab.instagram.instagram.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostIdAndDeletedFalse(Long postId);
    List<Comment> findByParentIdAndDeletedFalse(Long parentId);
}
