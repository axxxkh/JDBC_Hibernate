package LessonThree.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Animals")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private int age;
    private boolean tail;
}
