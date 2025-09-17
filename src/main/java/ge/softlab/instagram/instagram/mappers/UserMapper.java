package ge.softlab.instagram.instagram.mappers;

import ge.softlab.instagram.instagram.entities.User;
import ge.softlab.instagram.instagram.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserModel toModel(User user);

    List<UserModel> toModelList(List<User> users);
}