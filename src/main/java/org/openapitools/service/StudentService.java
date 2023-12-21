package org.openapitools.service;

import lombok.NonNull;
import org.openapitools.controller.CreateStudentRequest;
import org.openapitools.controller.StudentResponse;

import java.util.List;

public interface StudentService {

    @NonNull
    List<StudentResponse> findAll();

    @NonNull
    StudentResponse findById(@NonNull Long studentId);

    @NonNull
    StudentResponse createStudent(@NonNull CreateStudentRequest request);

    @NonNull
    StudentResponse update(@NonNull Long studentId, @NonNull CreateStudentRequest request);

    @NonNull
    void delete(@NonNull Long studentId);

}
