package ru.hogwarts2.school2.controller;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts2.school2.model.Faculty;
import ru.hogwarts2.school2.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService; // подключаем сервис

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public Collection<Faculty> getAll() {
        return facultyService.getAll();
    }
    @GetMapping("/filtered")
    public Collection<Faculty> getByColor (@RequestParam("color") String color){
        return  facultyService.getByColor(color);
    }

    @GetMapping("/{id}")
    public Faculty getById(@PathVariable("id") Long id) {
        return facultyService.getById(id);
    }

    @PostMapping
    public Faculty create(@RequestBody Faculty faculty) {          // @RequestBody-  тело запроса
        return facultyService.create(faculty);
    }

    @PutMapping("/{id}")
    public Faculty update(@PathVariable("id") Long id, @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        facultyService.delete(id);
    }
}
