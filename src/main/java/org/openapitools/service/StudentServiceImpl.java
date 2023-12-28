package org.openapitools.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.controller.CreateStudentRequest;
import org.openapitools.controller.StudentResponse;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public @NonNull List<StudentResponse> findAll() {
        log.info("findall method called");
        rabbitTemplate.convertAndSend("exchangeName", "findAllStudentsRoutingKey", "");
        return Collections.emptyList();
    }

    @Override
    public @NonNull StudentResponse findById(Long studentId) {
        log.info("findById method called");
        rabbitTemplate.convertAndSend("exchangeName", "findStudentByIdRoutingKey", studentId.toString());
        return new StudentResponse();
    }

    @Override
    public @NonNull StudentResponse createStudent(@NonNull CreateStudentRequest request) {
        log.info("createStudent method called");
        rabbitTemplate.convertAndSend("exchangeName", "createStudentRoutingKey", request);
        return new StudentResponse();
    }

    @Override
    public @NonNull StudentResponse update(Long studentId,@NonNull CreateStudentRequest request) {
        log.info("update method called");
        rabbitTemplate.convertAndSend("exchangeName", "updateStudentRoutingKey", studentId.toString(), (MessagePostProcessor) request);
        return new StudentResponse();
    }

    @Override
    public void delete(Long studentId) {
        log.info("delete method called");
        rabbitTemplate.convertAndSend("exchangeName", "deleteStudentRoutingKey", studentId.toString());
    }
}