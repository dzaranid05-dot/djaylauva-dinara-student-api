package com.dinara.studentapi;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentRepository repo;

    public StudentController(StudentRepository repo) { this.repo = repo; }

    @GetMapping("/info")
    public String info() { return "Student API by Dinara Djaylauva, ID 38086"; }

    @PostMapping("/students")
    public Student create(@RequestBody Student s) { return repo.save(s); }

    @GetMapping("/students")
    public List<Student> all() { return repo.findAll(); }
}
