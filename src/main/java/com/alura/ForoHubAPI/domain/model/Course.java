package com.alura.ForoHubAPI.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Course")
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "courseId")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
}
