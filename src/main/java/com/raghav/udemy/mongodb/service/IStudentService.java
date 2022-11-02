package com.raghav.udemy.mongodb.service;

import com.raghav.udemy.mongodb.entity.Student;

import java.util.List;

public interface IStudentService {
    Student createStudent(Student student);

    Student getStudentById(String id);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    String delete(String id);

    List<Student> findStudentsByName(String name);

    List<Student> findStudentsByNameAndEmail(String name, String email);

    List<Student> findStudentsByNameOrEmail(String name, String email);

    List<Student> getAllWithPagination(int pageNo, int pageSize);

    List<Student> getAllWithSorting();

    List<Student> getByDepartmentName(String deptName);

    List<Student> getBySubjectName(String subjectName);

    List<Student> getWithEmailLike(String pattern);

    List<Student> getNameStartsWith(String pattern);

    List<Student> getByDepartmentId(String deptId);
}

