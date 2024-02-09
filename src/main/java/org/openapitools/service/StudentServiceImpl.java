package org.openapitools.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.Student;
import org.openapitools.model.Subject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final List<Student> message = new ArrayList<>();
    @Override
    public @NonNull Optional<Student> findAll() {
        log.info("find all method called");

        return Optional.of((Student) message);
    }

    @Override
    public @NonNull Optional<Student> findById(@NonNull Long studentId) {
        log.info("findById method called");

        return message.stream().filter(it -> it.getId().equals(studentId)).findFirst();
    }

    @Override
    public void create(@NonNull Student student) {
        log.info("createStudent method called");
        message.add(student);

    }

    @Override
    public @NonNull Student update(@NonNull Long studentId, @NonNull Student request) {
        log.info("update method called");
        Student updateStudent = findById(studentId).orElseThrow(()-> new RuntimeException("Student not found with id: " + studentId));
        updateStudent.setName(request.getName());
        updateStudent.setSurname(request.getSurname());
        updateStudent.setAge(request.getAge());

        return updateStudent;
    }

    @Override
    public void delete(@NonNull Long studentId) {
        log.info("delete method called");
        message.removeIf(student -> student.getId().equals(studentId));
    }
}