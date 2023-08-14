package ru.hogwarts2.school2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.hogwarts2.school2.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> { // сущность, идентификатор
}
