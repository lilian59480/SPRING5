package com.spring.demo.service;

import com.spring.demo.dto.TeacherDto;
import com.spring.demo.dto.TeachersDto;
import com.spring.demo.exception.EntityNotFoundException;
import com.spring.demo.model.TeacherModel;
import com.spring.demo.repository.TeacherRepository;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @MockBean
    private TeacherRepository teacherRepository;

    @Test
    public void shouldFindTeacherById() {
        TeacherModel fooBar = new TeacherModel(1, "Foo", "Bar", "Spring");
        Mockito.when(teacherRepository.findById(1)).thenReturn(fooBar);

        TeacherDto teacherDTO = teacherService.findById(1);
        assertEquals("Foo", teacherDTO.getFirstName());
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowExceptionWhenTeacherIsNotFound() {
        Mockito.when(teacherRepository.findById(-22)).thenReturn(null);
        teacherService.findById(-22);
    }

    @Test
    public void shouldFindAllTeachers() {
        TeacherModel fooBar = new TeacherModel(1, "Foo", "Bar", "Spring");
        TeacherModel johnDoe = new TeacherModel(2, "John", "Doe", "Spring");

        Mockito.when(teacherRepository.findAll()).thenReturn(Arrays.asList(fooBar, johnDoe));

        TeachersDto teachersDTO = teacherService.findAll();
        assertNotNull(teachersDTO);
        assertNotNull(teachersDTO.getTeachers());
        assertEquals(2, teachersDTO.getTeachers().size());
    }

    @Test
    public void shouldReturnEmptyCollectionWhenNoTeachers() {
        Mockito.when(teacherRepository.findAll()).thenReturn(new ArrayList<>());

        TeachersDto teachersDTO = teacherService.findAll();
        assertNotNull(teachersDTO);
        assertNotNull(teachersDTO.getTeachers());
        assertEquals(0, teachersDTO.getTeachers().size());
    }
}
