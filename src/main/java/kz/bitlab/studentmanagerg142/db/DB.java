package kz.bitlab.studentmanagerg142.db;

import kz.bitlab.studentmanagerg142.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DB {
    List<Student> list = new ArrayList<>();
    private Long id = 1L;

    public DB() {
        list.add(new Student(id++, "Anton", "M", 100, "A"));
        list.add(new Student(id++, "Rauan", "M", 100, "A"));
        list.add(new Student(id++, "Bagzhan", "M", 100, "A"));
        list.add(new Student(id++, "Aizere", "M", 100, "A"));
        list.add(new Student(id++, "Daniyar", "M", 100, "A"));
    }

    public List<Student> getAll() {
        return list;
    }

    public void addStudent(Student student) {
        student.setId(id++);
        list.add(student);
    }
}
