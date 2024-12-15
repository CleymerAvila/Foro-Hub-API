package com.alura.ForoHubAPI.dto.topic;

import com.alura.ForoHubAPI.domain.model.TopicStatus;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicDTO(@NotNull Long topicId, String title, String message, TopicStatus status) {
    
}
