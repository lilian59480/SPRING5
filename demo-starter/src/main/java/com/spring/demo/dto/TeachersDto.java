package com.spring.demo.dto;

import java.util.List;

/**
 * Teacher's list representation for front
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
public class TeachersDto {

    private List<TeacherDto> teachers;

    public TeachersDto(List<TeacherDto> teachers) {
        this.teachers = teachers;
    }

    public List<TeacherDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherDto> teachers) {
        this.teachers = teachers;
    }

}
