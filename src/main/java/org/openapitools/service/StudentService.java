package org.openapitools.service;

import lombok.NonNull;
import org.openapitools.model.Student;

import java.util.List;

public interface StudentService {

    @NonNull
    List<Student> findAll();

    @NonNull
    Student findById(@NonNull Long studentId);

    @NonNull
    Student create(@NonNull Student request);

    @NonNull
    Student update(@NonNull Long studentId, @NonNull Student request);

    void delete(@NonNull Long studentId);

}
