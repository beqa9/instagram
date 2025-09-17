package ge.softlab.instagram.instagram.mappers;

import ge.softlab.instagram.instagram.entities.Comment;
import ge.softlab.instagram.instagram.models.CommentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "parent.id", target = "parentId")
    CommentModel toModel(Comment comment);

    List<CommentModel> toModelList(List<Comment> comments);
}