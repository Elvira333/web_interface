package org.openapitools.configuration.controllers;

import lombok.AllArgsConstructor;
import org.openapitools.model.Student;
import org.openapitools.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping(value = "/{studentId}", produces = APPLICATION_JSON_VALUE)
    public Student findById(@PathVariable Long studentId) {
        return studentService.findById(studentId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Student create(@RequestBody Student request) {
        return studentService.create(request);
    }

    @PatchMapping(value = "/{studentId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Student update(@PathVariable Long studentId, @RequestBody Student request) {
        return studentService.update(studentId, request);
    }
}
