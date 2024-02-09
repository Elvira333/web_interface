package org.openapitools.configuration.controllers;

import lombok.RequiredArgsConstructor;
import org.openapitools.model.Student;
import org.openapitools.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class KafkaController {

    @Value("${app.kafka.kafkaMessageTopic}")
    private String topicName;

    private final KafkaTemplate<String, Student> kafkaTemplate;

    private StudentService studentService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Student student) {
        kafkaTemplate.send(topicName,student);

        return ResponseEntity.ok("Message sent to kafka");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id).orElseThrow());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        Student updateStudent = studentService.update(id, student);
        kafkaTemplate.send("student-updated", updateStudent);

        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.delete(id);
        kafkaTemplate.send("student-deleted",student);
        return ResponseEntity.noContent().build();
    }
}
