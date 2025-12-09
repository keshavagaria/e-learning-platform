package com.labmentix.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {

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

    @OneToMany(fetch = FetchType.EAGER)
    //@Enumerated(EnumType.STRING)
    private Set<RoleType> roles = new HashSet<>();



    //private String roles;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   // @ToString.Exclude
    private List<Course> enrolledCourses=new ArrayList<>();
}
