package com.dinara.studentapi;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

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

    @GetMapping("/students/{id}")
    public Student one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }
}
