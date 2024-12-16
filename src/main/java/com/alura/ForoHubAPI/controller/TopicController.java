package com.alura.ForoHubAPI.controller;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.ForoHubAPI.domain.model.Topic;
import com.alura.ForoHubAPI.domain.repository.TopicRepository;
import com.alura.ForoHubAPI.dto.topic.ListTopicDTO;
import com.alura.ForoHubAPI.dto.topic.NewTopicDTO;
import com.alura.ForoHubAPI.dto.topic.RegisterTopicDTO;
import com.alura.ForoHubAPI.dto.topic.TopicDTO;
import com.alura.ForoHubAPI.dto.topic.UpdateTopicDTO;
import com.alura.ForoHubAPI.service.topic.TopicService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<NewTopicDTO> registerTopic(@RequestBody @Valid RegisterTopicDTO data, 
                                                UriComponentsBuilder uriBuilder){

        var topicDetails = topicService.publish(data);

        URI url = uriBuilder.path("/topics/{topicId}").buildAndExpand(topicDetails.topicId()).toUri();

        return ResponseEntity.created(url).body(topicDetails); 
    }

    @GetMapping
    public ResponseEntity<Page<ListTopicDTO>> getAllTopics(Pageable pageable){
        return ResponseEntity.ok(topicRepository.findAll(pageable).map(ListTopicDTO::new));
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicDTO> getTopicDetails(@PathVariable Long topicId){
        
        Topic topic = topicRepository.getReferenceById(topicId);

        return ResponseEntity.ok(new TopicDTO(topic));
    }

    @DeleteMapping("/{topicId}")
    @Transactional
    public ResponseEntity<Void> deleteTopic(@PathVariable long topicId){
        topicRepository.deleteById(topicId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<NewTopicDTO> updateTopic(@RequestBody @Valid UpdateTopicDTO data){
        Topic topic = topicRepository.getReferenceById(data.topicId());

        topic.updateData(data);

        Topic topicSaved = topicRepository.save(topic);
        
        return ResponseEntity.ok(new NewTopicDTO(topicSaved));
    }


}
