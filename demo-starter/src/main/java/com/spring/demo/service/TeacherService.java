package com.spring.demo.service;

import com.spring.demo.dto.TeacherDto;
import com.spring.demo.dto.TeachersDto;
import com.spring.demo.exception.EntityNotFoundException;
import com.spring.demo.model.TeacherModel;
import com.spring.demo.repository.TeacherRepository;
import java.text.MessageFormat;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service that manipulate Teacher
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public TeachersDto findAll() {
        return new TeachersDto(
                teacherRepository.findAll().stream().map(this::fromModelToDto).collect(Collectors.toList())
        );
    }

    public TeacherDto findById(int id) {

        TeacherModel model = teacherRepository.findById(id);

        if (model == null) {
            throw new EntityNotFoundException(MessageFormat.format("Teacher {0} not found", id));
        }

        return this.fromModelToDto(model);
    }

    private TeacherDto fromModelToDto(TeacherModel model) {
        return new TeacherDto(model.getId(), model.getFirstName(), model.getLastName(), model.getSubject());
    }

}
