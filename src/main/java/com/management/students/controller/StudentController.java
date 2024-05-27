package com.management.students.controller;

import com.management.students.entity.Student;
import com.management.students.service.StudentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentSevice studentSevice;

    @Autowired
    public StudentController(StudentSevice studentSevice) {
        this.studentSevice = studentSevice;
    }

    @GetMapping("/list")
    public String studentList(Model model) {
        List<Student> students = studentSevice.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "addStudentForm";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentSevice.save(student);
        return "redirect:/students/list";
    }

}
