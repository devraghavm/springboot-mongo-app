package com.raghav.udemy.mongodb.api;

import com.raghav.udemy.mongodb.entity.Student;
import com.raghav.udemy.mongodb.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping(value = "/get-by-id/{id}")
    public @ResponseBody
    ResponseEntity<Student> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping(value = "/all")
    public @ResponseBody
    ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody
    ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        student.setId(id);
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

    @GetMapping(value = "/students-by-name/{name}")
    public @ResponseBody
    ResponseEntity<List<Student>> studentsByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.findStudentsByName(name));

    }

    @GetMapping(value = "/students-by-name-and-mail")
    public @ResponseBody
    ResponseEntity<List<Student>> studentsByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return ResponseEntity.ok(studentService.findStudentsByNameAndEmail(name, email));

    }

    @GetMapping(value = "/students-by-name-or-mail")
    public @ResponseBody
    ResponseEntity<List<Student>> studentsByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return ResponseEntity.ok(studentService.findStudentsByNameOrEmail(name, email));

    }

    @GetMapping(value = "/all-with-pagination")
    public @ResponseBody
    ResponseEntity<List<Student>> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
        return ResponseEntity.ok(studentService.getAllWithPagination(pageNo, pageSize));

    }

    @GetMapping(value = "/all-with-sorting")
    public @ResponseBody
    ResponseEntity<List<Student>> getAllWithSorting() {
        return ResponseEntity.ok(studentService.getAllWithSorting());
    }

    @GetMapping(value = "/by-department-name")
    public @ResponseBody
    ResponseEntity<List<Student>> getByDepartmentName(@RequestParam String deptName) {
        return ResponseEntity.ok(studentService.getByDepartmentName(deptName));
    }

    @GetMapping(value = "/by-subject-name")
    public @ResponseBody
    ResponseEntity<List<Student>> getBySubjectName(@RequestParam String subjectName) {
        return ResponseEntity.ok(studentService.getBySubjectName(subjectName));
    }

    @GetMapping(value = "/email-like")
    public @ResponseBody
    ResponseEntity<List<Student>> getWithEmailLike(@RequestParam String pattern) {
        return ResponseEntity.ok(studentService.getWithEmailLike(pattern));
    }

    @GetMapping(value = "/name-starts-with")
    public @ResponseBody
    ResponseEntity<List<Student>> getNameStartsWith(@RequestParam String pattern) {
        return ResponseEntity.ok(studentService.getNameStartsWith(pattern));
    }

    @GetMapping(value = "/by-department-id")
    public @ResponseBody
    ResponseEntity<List<Student>> getByDepartmentId(@RequestParam String deptId) {
        return ResponseEntity.ok(studentService.getByDepartmentId(deptId));
    }
}
