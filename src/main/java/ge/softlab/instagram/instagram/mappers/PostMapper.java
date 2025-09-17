package ge.softlab.instagram.instagram.mappers;

import ge.softlab.instagram.instagram.entities.Post;
import ge.softlab.instagram.instagram.models.PostModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "user.id", target = "userId")
    PostModel toModel(Post post);

    List<PostModel> toModelList(List<Post> posts);
}

