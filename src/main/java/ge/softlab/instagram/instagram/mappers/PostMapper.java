package ge.softlab.instagram.instagram.mappers;

import ge.softlab.instagram.instagram.entities.Post;
import ge.softlab.instagram.instagram.models.PostModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostModel toModel(Post post);

    Post toEntity(PostModel model);
}

