package com.alura.ForoHubAPI.domain.repository;

import com.alura.ForoHubAPI.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alura.ForoHubAPI.domain.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

    boolean existsByTitleAndMessage(String title, String message);

    @Query("SELECT COUNT(t) FROM Topic t WHERE t.user.userId = :userId AND DATE(t.createdAt) = CURRENT_DATE")
    int countTopicsCreatedByUserToday(@Param("userId")Long userId);

    @Query("SELECT COUNT(DISTINCT t) FROM Topic t JOIN t.replies r WHERE r.user.id = :userId")
    int countTopicInteractionFromUser(@Param("userId") Long userId);

    @Query("SELECT t FROM Topic t JOIN t.course c WHERE c.category = :courseCategory")
    Page<Topic> getTopicsByCoursesCategory(@Param("courseCategory") Category courseCategory, Pageable pageable);
}
