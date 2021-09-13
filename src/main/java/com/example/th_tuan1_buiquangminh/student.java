package com.example.th_tuan1_buiquangminh;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="students")
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="first_name", nullable = false)
    private String firstName;
    @Column(name ="last_name", nullable = false)
    private String lastName;
    @Column(name ="email", nullable = false)
    private String email;


}

