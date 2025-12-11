package kz.bitlab.studentmanagerg142.controller;

import kz.bitlab.studentmanagerg142.db.DB;
import kz.bitlab.studentmanagerg142.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    DB db = new DB();

    @GetMapping("/")
    public String start(Model model,
                        @RequestParam(name = "search_name", required = false) String searchName) {
        if (searchName != null) {
            List<Student> filtered;
            filtered = db.getAll().stream()
                    .filter(e -> e.getName().toLowerCase().contains(searchName.toLowerCase()))
                    .toList();
            model.addAttribute("students", filtered);
        } else {
            model.addAttribute("students", db.getAll());
        }
        return "students";
    }

    @GetMapping("/add-student")
    public String addStudent(Model model) {
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudentPost(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "surname") String surname,
                                 @RequestParam(name = "exam") Integer exam) {
        Student st = Student.builder()
                .name(name)
                .surname(surname)
                .exam(exam)
                .mark(getMark(exam))
                .build();
        db.addStudent(st);
        return "redirect:/";
    }

    private String getMark(Integer exam) {
        if (exam < 25) return "F";
        else if (exam < 50 && exam >= 25) return "D";
        else if (exam >= 50 && exam < 70) return "C";
        else if (exam >= 70 && exam < 90) return "B";
        else return "A";
    }
}
