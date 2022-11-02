package com.raghav.udemy.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "student")
public class Student {
    @Id
    private String id;

    private String name;

    @Field(name = "mail")
    private String email;

    @DBRef
    private Department department;

    @DBRef
    private List<Subject> subjects;

    @Transient
    private double percentage;

    public double getPercentage() {
        double total = 0.00;
        total = Objects.requireNonNull(subjects).stream()
                       .mapToInt(s -> s.getMarks())
                       .sum() / subjects.size();
        return total;
    }
}
