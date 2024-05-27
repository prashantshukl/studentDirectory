package com.management.students.service;

import com.management.students.entity.Student;

import java.util.List;

public interface StudentSevice {
    List<Student> findAll();
    void save(Student student);
}
