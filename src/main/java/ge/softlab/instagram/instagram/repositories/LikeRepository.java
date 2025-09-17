package ge.softlab.instagram.instagram.repositories;

import ge.softlab.instagram.instagram.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPostIdAndDeletedFalse(Long postId);
    List<Like> findByUserIdAndDeletedFalse(Long userId);
}
