package ru.hogwarts2.school2.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts2.school2.model.Faculty;
import ru.hogwarts2.school2.repository.FacultyRepository;


import java.util.*;




@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {
    @Mock
    private FacultyRepository facultyRepository;

    @InjectMocks
    private FacultyService facultyService;

    @Test
    void receiving() { //получение
        String color = "синий";
        List<Faculty> faculties = getFaculty();

        Mockito.when(facultyRepository.findAllByColor(color)).thenReturn(faculties);

       Collection<Faculty> result = facultyService.getByColor(color);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2,result.size());

    }
    private List<Faculty> getFaculty(){
Faculty firstFacultu = new Faculty();
Faculty secondFacultu = new Faculty();
firstFacultu.setColor("cиний");
secondFacultu.setColor("зеленый");
return List.of(firstFacultu, secondFacultu);

    }
}
