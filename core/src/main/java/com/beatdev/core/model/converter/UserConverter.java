package com.beatdev.core.model.converter;

import com.beatdev.core.model.User;
import com.beatdev.core.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDto>{
    @Override
    public User convertToEntity(UserDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setStatus(dto.getStatus());
        user.setImageURI(dto.getImageURI());
        user.setPassword(dto.getPassword());
        return user;
    }

    @Override
    public UserDto convertToDto(User entity) {
        UserDto dto = new UserDto();
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        dto.setImageURI(entity.getImageURI());
        return dto;
    }
}
