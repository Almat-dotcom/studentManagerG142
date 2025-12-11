package kz.bitlab.studentmanagerg142.controller;

import kz.bitlab.studentmanagerg142.model.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    List<Student> list = new ArrayList<>();
    private Long id = 1L;

    public StudentController() {
        list.add(new Student(id++, "Anton", "M", 100, "A"));
        list.add(new Student(id++, "Rauan", "M", 100, "A"));
        list.add(new Student(id++, "Bagzhan", "M", 100, "A"));
        list.add(new Student(id++, "Aizere", "M", 100, "A"));
        list.add(new Student(id++, "Daniyar", "M", 100, "A"));
    }

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("students", list);
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
        Student st = new Student();
        st.setName(name);
        st.setSurname(surname);
        st.setExam(exam);
        st.setId(id++);
        if (exam < 25) {
            st.setMark("F");
        } else if (exam < 50 && exam >= 25) {
            st.setMark("D");
        } else if (exam >= 50 && exam < 70) {
            st.setMark("C");
        } else if (exam >= 70 && exam < 90) {
            st.setMark("B");
        } else {
            st.setMark("A");
        }
        list.add(st);
        return "redirect:/";
    }
}
