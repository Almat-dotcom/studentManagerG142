package kz.bitlab.studentmanagerg142.controller;

import kz.bitlab.studentmanagerg142.db.DB;
import kz.bitlab.studentmanagerg142.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NewController {
    DB db = new DB();

    @GetMapping("/new")
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
}
