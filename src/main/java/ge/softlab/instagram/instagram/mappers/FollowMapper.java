package ge.softlab.instagram.instagram.mappers;

import ge.softlab.instagram.instagram.entities.Follow;
import ge.softlab.instagram.instagram.models.FollowModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FollowMapper {

    FollowModel toModel(Follow follow);

    Follow toEntity(FollowModel model);
}