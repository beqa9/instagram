package ge.softlab.instagram.instagram.mappers;

import ge.softlab.instagram.instagram.entities.Comment;
import ge.softlab.instagram.instagram.models.CommentModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentModel toModel(Comment comment);

    Comment toEntity(CommentModel model);
}
