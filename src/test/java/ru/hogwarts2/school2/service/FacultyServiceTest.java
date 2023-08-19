package ru.hogwarts2.school2.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class FacultyServiceTest {

    @Test
    @DisplayName("Проверка по индексу")
    void getByIndex() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
        Integer element = list.get(2);
        assertNotNull(element);
        assertEquals(2, element);
    }

    @Test
    void indexOutRange() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(4);
        });

    }
}
