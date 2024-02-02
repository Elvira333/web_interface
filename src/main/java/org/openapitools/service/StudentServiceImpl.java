package org.openapitools.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.Student;
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
    public @NonNull List<Student> findAll() {
        log.info("find all method called");
        rabbitTemplate.convertAndSend("exchangeName", "findAllStudentsRoutingKey", "");
        return Collections.emptyList();
    }

    @Override
    public @NonNull Student findById(@NonNull Long studentId) {
        log.info("findById method called");
        rabbitTemplate.convertAndSend("exchangeName", "findStudentByIdRoutingKey", studentId.toString());
        return new Student();
    }

    @Override
    public @NonNull Student create(@NonNull Student request) {
        log.info("createStudent method called");
        rabbitTemplate.convertAndSend("exchangeName", "createStudentRoutingKey", request);
        return new Student();
    }

    @Override
    public @NonNull Student update(@NonNull Long studentId, @NonNull Student request) {
        log.info("update method called");
        rabbitTemplate.convertAndSend("exchangeName", "updateStudentRoutingKey", studentId.toString(), (MessagePostProcessor) request);
        return new Student();
    }

    @Override
    public void delete(@NonNull Long studentId) {
        log.info("delete method called");
        rabbitTemplate.convertAndSend("exchangeName", "deleteStudentRoutingKey", studentId.toString());
    }
}