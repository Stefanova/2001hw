package com.example._hw;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @GetMapping("/students/grade/{grade}")
    public List<Student> getAllStudents(@RequestParam int grade) {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findByGrade(grade).forEach(students::add);
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") long id) {
        Optional<Student> studentData =
                studentRepository.findById(id);
        if (studentData.isPresent()) {
            return studentData.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student students) {
        return studentRepository.save(new Student(students.getFullName(), students.getGrade(), students.getEmail(), true));
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") long id,
                           @RequestBody Student student) {
        Optional<Student> studentData =
                studentRepository.findById(id);
        if (studentData.isPresent()) {
            Student _students = studentData.get();
            _students.setFullName(student.getFullName());
            _students.setGrade(student.getGrade());
            _students.setEmail(student.getEmail());
            _students.setActive(student.getActive());
            return studentRepository.save(_students);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/students/{id}")
    public HttpStatus deleteStudent(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
}