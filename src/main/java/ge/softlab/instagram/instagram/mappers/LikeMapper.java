package ge.softlab.instagram.instagram.mappers;

import ge.softlab.instagram.instagram.entities.Like;
import ge.softlab.instagram.instagram.models.LikeModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeMapper {

    LikeModel toModel(Like like);

    Like toEntity(LikeModel model);
}