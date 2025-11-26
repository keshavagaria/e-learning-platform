package com.labmentix.controller;

import com.labmentix.entities.Course;
import com.labmentix.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/course/")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

//    @Autowired
//    private EnrollmentService enrollmentService;
//
//    @Autowired
//    private EmailSenderService emailSenderService;

    @GetMapping("/courses")
    public String getAllCourses(Model model) {

       List<Course> courseList =  courseService.getAllCourses();
        log.info("courseList : " + courseList);
        model.addAttribute("title", "Courses");
        model.addAttribute("courseList", courseList);

        return "courses/courses";
    }

    @GetMapping()
    public String getCourseById(@RequestParam("id") Long id,Model model) {

        Course course =  courseService.getCourseById(id);
        model.addAttribute("courseDetails",course);
        return "courses/course-details";
    }

    @PostMapping("/add")
    public Course createCourse(@RequestBody Course course) {

        return courseService.createCourse(course);
    }

    @PostMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

//    @DeleteMapping("/{id}")
//    public void deleteCourse(@PathVariable Long id) {
//        courseService.deleteCourse(id);
//    }
//
//    @PostMapping("/{courseId}/enroll")
//    public String enroll(@PathVariable Long courseId, Authentication authentication) {
//
//        String username=null;
//        String email=null;
//        if(authentication==null) {
//            return "redirect:/api/course/courses?fail";
//        }
//        else {
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof UserInfoUserDetails) {
//               username = ((UserInfoUserDetails) principal).getUsername();
//                email = ((UserInfoUserDetails) principal).getEmail();
//                // use id
//            }
//        }
//
//        enrollmentService.enrollUserInCourse(username, courseId);
//        log.info("username :"+username);
//      //  sendMail(email,courseId);
//        return "redirect:/api/course/courses?success";
//    }

  //  @EventListener(ApplicationReadyEvent.class)
//    public void sendMail(String email,Long courseId){
//        Course course =  courseService.getCourseById(courseId);
//        emailSenderService.sendMail(email,
//                        "Course Enrollment Notification",
//                    "You have enrolled for the course "+course+ "on "+ LocalDate.now());
//    }
//
//    @GetMapping("/quiz")
//    public String getCourseQuiz() {
//
//        return "courses/quiz";
//    }
}
