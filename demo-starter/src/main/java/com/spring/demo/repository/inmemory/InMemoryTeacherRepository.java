package com.spring.demo.repository.inmemory;

import com.spring.demo.model.TeacherModel;
import com.spring.demo.repository.TeacherRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

/**
 * Mock of some Teachers
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Repository()
@ConditionalOnProperty(name = "demo.repository", havingValue = "mock")
public class InMemoryTeacherRepository implements TeacherRepository {

    private static final List<TeacherModel> TEACHER = Arrays.asList(
            new TeacherModel(0, "Alain", "Husson", "Anglais"),
            new TeacherModel(1, "Philippe", "Kubiak", "Info"),
            new TeacherModel(2, "Thierry", "Fricheteau", "Projet")
    );

    @Override
    public List<TeacherModel> findAll() {
        return InMemoryTeacherRepository.TEACHER;
    }

    @Override
    public TeacherModel findById(int id) {
        return InMemoryTeacherRepository.TEACHER.stream().filter((t) -> {
            return t.getId() == id;
        }).findFirst().orElse(null);
    }

    @Override
    public void save(TeacherModel teacher) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
