package com.alura.ForoHubAPI.controller;

import com.alura.ForoHubAPI.dto.RegisterCourseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping()
    public void saveCourse(@RequestBody RegisterCourseDTO data){
        System.out.println(data);
    }
}
