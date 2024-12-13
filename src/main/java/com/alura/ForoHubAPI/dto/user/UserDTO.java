package com.alura.ForoHubAPI.dto.user;

import java.util.List;

import com.alura.ForoHubAPI.domain.model.User;
import com.alura.ForoHubAPI.dto.profile.ProfileDTO;

public record UserDTO(Long userId, String name, List<ProfileDTO> profiles) {
 
    public UserDTO(User user){
        this(user.getUserId(), user.getName(), user.getProfiles().stream().map(ProfileDTO::new).toList());
    }
}