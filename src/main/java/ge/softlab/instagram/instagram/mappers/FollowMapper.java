package ge.softlab.instagram.instagram.mappers;

import ge.softlab.instagram.instagram.entities.Follow;
import ge.softlab.instagram.instagram.models.FollowModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface FollowMapper {

    @Mapping(source = "follower.id", target = "followerId")
    @Mapping(source = "following.id", target = "followingId")
    FollowModel toModel(Follow follow);

    List<FollowModel> toModelList(List<Follow> follows);
}