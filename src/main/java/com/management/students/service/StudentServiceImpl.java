package com.management.students.service;

import com.management.students.dao.StudentRepository;
import com.management.students.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentSevice{

    StudentRepository studentRepository;


    @Autowired
    StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        Optional<Student> op = studentRepository.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public void remove(Student student) {
        studentRepository.delete(student);
    }
}
