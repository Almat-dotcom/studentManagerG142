package kz.bitlab.studentmanagerg142.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    private Long id;

    private String name;

    private String surname;

    private int exam;

    private String mark;
}
