package com.example.AtosTest.DTO;

import com.example.AtosTest.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer {

    public User toEntity(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setBirthdate(dto.getBirthdate());
        user.setCountry(dto.getCountry());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setGender(dto.getGender());
        return user;
    }

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setBirthdate(user.getBirthdate());
        dto.setCountry(user.getCountry());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setGender(user.getGender());
        return dto;
    }
}

