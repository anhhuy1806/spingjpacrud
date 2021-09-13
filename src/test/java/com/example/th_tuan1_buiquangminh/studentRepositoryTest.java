package com.example.th_tuan1_buiquangminh;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;



@DataJpaTest
public class studentRepositoryTest {
    @Autowired
    private studentRepository studentRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void savestudentRepository(){
        student student= com.example.th_tuan1_buiquangminh.student.builder()
                .firstName("Bui")
                .lastName("Minh")
                .email("buiquangminh2501@gmail.com")
                .build();
        studentRepository.save(student);
        //Assertions.assertThat(student.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)

    public void getstudentTest(){

        student student = studentRepository.findById(1L).get();

        //Assertions.assertThat(student.getId()).isEqualTo(1L);

    }
    @Test
    @Order(3)

    public void getListOfStudentTest(){
        List<student> students = studentRepository.findAll();
        System.out.print(students);
        //Assertions.assertThat(employees.size()).isGreaterThan(0);

    }
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateStudentTest(){

        student student = studentRepository.findById(1L).get();

        student.setEmail("buiquangminh@gmail.com");

        student studentUpdated =  studentRepository.save(student);

        //Assertions.assertThat(studentUpdated.getEmail()).isEqualTo("buiquangminh@gmail.com");

    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteStudentTest(){

        student student = studentRepository.findById(1L).get();

        studentRepository.delete(student);

        //employeeRepository.deleteById(1L);

        student student1 = null;

        Optional<student> optionalStudent = studentRepository.findById(1L);
        //Optional<student> optionalStudent = studentRepository.findByEmail("buiquangminh@gmail.com");

        if(optionalStudent.isPresent()){
            student1 = optionalStudent.get();
        }

        //Assertions.assertThat(student1).isNull();
    }

    }




