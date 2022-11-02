package com.raghav.udemy.mongodb.service;

import com.raghav.udemy.mongodb.entity.Student;
import com.raghav.udemy.mongodb.repository.DepartmentRepository;
import com.raghav.udemy.mongodb.repository.StudentRepository;
import com.raghav.udemy.mongodb.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class StudentService implements IStudentService {

    private StudentRepository studentRepository;

    private DepartmentRepository departmentRepository;

    private SubjectRepository subjectRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Student createStudent(Student student) {
        if (Objects.nonNull(student.getDepartment())) {
            departmentRepository.save(student.getDepartment());
        }
        if (Objects.nonNull(student.getSubjects())) {
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        log.info("Inside getAllStudents()");
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String delete(String id) {
        studentRepository.deleteById(id);
        return "Student has been deleted";
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentRepository.getByName(name);
    }

    @Override
    public List<Student> findStudentsByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    @Override
    public List<Student> findStudentsByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    @Override
    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> getAllWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return studentRepository.findAll(sort);
    }

    @Override
    public List<Student> getByDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    @Override
    public List<Student> getBySubjectName(String subjectName) {
        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    @Override
    public List<Student> getWithEmailLike(String pattern) {
        return studentRepository.findByEmailIsLike(pattern);
    }

    @Override
    public List<Student> getNameStartsWith(String pattern) {
        return studentRepository.findByNameStartsWith(pattern);
    }

    @Override
    public List<Student> getByDepartmentId(String deptId) {
        return studentRepository.findByDepartmentId(deptId);
    }
}
