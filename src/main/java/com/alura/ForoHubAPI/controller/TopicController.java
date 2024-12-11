package com.alura.ForoHubAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @GetMapping
    public String topics(){
        return "Si yo escribo lo que sea en esta mierda de una se actualiza alla? WOW!!!";
    }

}
