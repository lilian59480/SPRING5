package com.spring.demo.repository;

import com.spring.demo.model.TeacherModel;
import java.util.List;

/**
 * Manipulaiton of Teacher
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
public interface TeacherRepository {

    /**
     * Return a list of all teachers
     *
     * @return A list of teachers
     */
    List<TeacherModel> findAll();

    /**
     * Return a teacher by its id
     *
     * @param id Id of the teacher
     * @return A teacher or null if not found
     */
    TeacherModel findById(int id);

    /**
     * Save a new teacher
     *
     * @param teacher A new teacher
     */
    void save(TeacherModel teacher);
}
