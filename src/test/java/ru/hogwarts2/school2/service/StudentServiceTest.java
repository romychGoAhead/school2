package ru.hogwarts2.school2.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class StudentServiceTest {
    @Test
    @DisplayName("Проверка по индексу")
    void getByIndex() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        Integer element = list.get(3);
        assertNotNull(element);
        assertEquals(3, element);
    }

    @Test
    void indexOutRange() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(5);
        });

    }
}
