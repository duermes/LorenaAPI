package com.lorena.api.rest;

import com.lorena.api.database.TopicRepository;
import com.lorena.api.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        // Implement topic creation logic here
        Topic createdTopic = topicRepository.save(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTopic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topicDetails) {
        // Implement topic update logic here
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Topic existingTopic = optionalTopic.get();
        // Update the existingTopic with topicDetails
        // Save the updated topic using topicRepository.save()

        Topic updatedTopic = topicRepository.save(existingTopic);

        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        // Implement topic deletion logic here
        topicRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
