package ge.softlab.instagram.instagram.mappers;

import ge.softlab.instagram.instagram.entities.Like;
import ge.softlab.instagram.instagram.models.LikeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "post.id", target = "postId")
    LikeModel toModel(Like like);

    List<LikeModel> toModelList(List<Like> likes);
}