package app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

@Table(name="employee")
public class Employee {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private double salary;
    private String department;
}
