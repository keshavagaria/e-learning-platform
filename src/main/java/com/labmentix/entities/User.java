package com.labmentix.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.labmentix.enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNo;
    private String dob;
    private String gender;
    private String location;
    private String profession;
    private String linkedin_url;
    private String github_url;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    private Set<RoleType> roles = new HashSet<>();

    private String roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Course> enrolledCourses=new ArrayList<>();
}
