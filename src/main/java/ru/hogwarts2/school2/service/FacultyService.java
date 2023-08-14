package ru.hogwarts2.school2.service;
import org.springframework.stereotype.Service;
import ru.hogwarts2.school2.exception.DataNotFoundException;
import ru.hogwarts2.school2.model.Faculty;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> map = new HashMap<>();
    private Long COUNTER = 1L;
// добавляем CRUD операции

    public Faculty getById(Long id) {    // вернуть по Id
        return map.get(id);
    }
    public Collection <Faculty> getByColor(String color){
        return map.values().stream()
                .filter(faculty -> faculty.getColor().equalsIgnoreCase(color))
                .toList();
    }

    public Collection<Faculty> getAll() {   //вернуть всех
        return map.values();
    }

    public Faculty create(Faculty faculty) {
        Long nextId = COUNTER++;
        faculty.setId(nextId);
        map.put(faculty.getId(), faculty);
        return faculty;

    }

    public Faculty update(Long id, Faculty faculty) {
        if (!map.containsKey(id)) {
            throw new DataNotFoundException();
        }
        Faculty exsitingFaculty = map.get(id);
        exsitingFaculty.setName(faculty.getName());
        exsitingFaculty.setColor(faculty.getColor());
        return exsitingFaculty;
    }

    public void delete(Long id) {
        if (map.remove(id) == null) {
            throw new DataNotFoundException();
        }

    }
}