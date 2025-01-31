package com.alura.ForoHubAPI.dto.reply;

import java.time.LocalDateTime;

import com.alura.ForoHubAPI.domain.model.Reply;

import jakarta.validation.constraints.NotNull;

public record ReplyDTO(@NotNull Long replyId, String message, Long topicId,
                         String authorName, LocalDateTime createdAt, String solution ) {
    
    public ReplyDTO(Reply reply){
        this(reply.getReplyId(), reply.getMessage(), reply.getTopic().getTopicId(),
            reply.getUser().getName(), reply.getCreatedAt(), reply.getSolution());
    }
}
