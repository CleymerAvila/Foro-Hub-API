package com.alura.ForoHubAPI.dto.profile;

import com.alura.ForoHubAPI.domain.model.Profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfileDTO(@NotNull Long profileId,  @NotBlank String name ) {
    
    public ProfileDTO(Profile profile){
        this(profile.getProfileId(), profile.getName());
    }
}
