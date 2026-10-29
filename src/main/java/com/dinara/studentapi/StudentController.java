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
    public String info() { return "Student API v1.1 by Dinara Djaylauva, ID 38086"; }

    @PostMapping("/students")
    public Student create(@RequestBody Student s) { return repo.save(s); }

    @GetMapping("/students")
    public List<Student> all() { return repo.findAll(); }

    @GetMapping("/students/{id}")
    public Student one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    @PutMapping("/students/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        Student st = repo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        st.setName(s.getName());
        st.setEmail(s.getEmail());
        return repo.save(st);
    }

    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        repo.deleteById(id);
    }
}
