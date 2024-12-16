package com.alura.ForoHubAPI.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.ForoHubAPI.domain.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

    boolean existsByTitleAndMessage(String title, String message);
    
}
