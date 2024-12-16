package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.UserDto;
import com.akdriss.cvback.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class UserMapper implements GenericMapper<User, UserDto> {
    @Override
    public UserDto toDto(User user) {
        return null;
    }

    @Override
    public User toEntity(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> toListDto(List<User> users) {
        return null;
    }

    @Override
    public List<User> toListEntities(List<UserDto> userDtos) {
        return null;
    }
}
