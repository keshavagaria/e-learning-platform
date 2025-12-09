package com.labmentix.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("course_id")
    private Long courseId;
    @JsonProperty("course_name")
    private String courseName;
    private int price;
    @JsonProperty("instructor")
    private String instructor;
    private String description;

    @OneToMany( cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<CourseSection> sections;
//
//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Feedback> feedbacks;
//
//    @OneToMany()
//    @JsonIgnore
//    private List<Question> questions;

    @ManyToOne
//    @JoinColumn(name = "id")
    @ToString.Exclude
    private User user;


}
