package com.labmentix.service;

import com.labmentix.entities.Course;
import com.labmentix.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getCourseByUserId(Long id) {
        return courseRepository.findCourseByUserId(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setDescription(updatedCourse.getDescription());

            existingCourse.setPrice(updatedCourse.getPrice());
            existingCourse.setInstructor(updatedCourse.getInstructor());

            return courseRepository.save(existingCourse);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
