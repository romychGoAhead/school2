package ru.hogwarts2.school2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.hogwarts2.school2.model.Student;
import ru.hogwarts2.school2.repository.StudentRepository;


import java.util.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void receiving() {
        int age = 12;
        List<Student> students = getStudent();

        Mockito.when(studentRepository.findAllByAge(age)).thenReturn(students);

        Collection<Student> result = studentService.getByAge(age);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());

    }

    private List<Student> getStudent() {
        Student firstStudent = new Student();
        Student secondStudent = new Student();
        firstStudent.setAge(12);
        secondStudent.setAge(13);
        return List.of(firstStudent, secondStudent);

    }
}
