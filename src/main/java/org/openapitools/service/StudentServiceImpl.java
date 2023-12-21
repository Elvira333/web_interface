package org.openapitools.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.openapitools.controller.CreateStudentRequest;
import org.openapitools.controller.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final RabbitTemplate rabbitTemplate;
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public @NonNull List<StudentResponse> findAll() {
        logger.info("findall method called");
        rabbitTemplate.convertAndSend("exchangeName", "findAllStudentsRoutingKey", "");
        return Collections.emptyList();
    }

    @Override
    public @NonNull StudentResponse findById(Long studentId) {
        logger.info("findById method called");
        rabbitTemplate.convertAndSend("exchangeName", "findStudentByIdRoutingKey", studentId.toString());
        return new StudentResponse();
    }

    @Override
    public @NonNull StudentResponse createStudent(@NonNull CreateStudentRequest request) {
        logger.info("createStudent method called");
        rabbitTemplate.convertAndSend("exchangeName", "createStudentRoutingKey", request);
        return new StudentResponse();
    }

    @Override
    public @NonNull StudentResponse update(Long studentId,@NonNull CreateStudentRequest request) {
        logger.info("update method called");
        rabbitTemplate.convertAndSend("exchangeName", "updateStudentRoutingKey", studentId.toString(), (MessagePostProcessor) request);
        return new StudentResponse();
    }

    @Override
    public void delete(Long studentId) {
        logger.info("delete method called");
        rabbitTemplate.convertAndSend("exchangeName", "deleteStudentRoutingKey", studentId.toString());
    }
}