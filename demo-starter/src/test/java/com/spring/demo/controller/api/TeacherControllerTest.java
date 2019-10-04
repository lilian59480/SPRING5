package com.spring.demo.controller.api;

import com.spring.demo.dto.TeacherDto;
import com.spring.demo.dto.TeachersDto;
import com.spring.demo.exception.EntityNotFoundException;
import com.spring.demo.service.TeacherService;
import java.util.Arrays;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TeacherApiController.class)
public class TeacherControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TeacherService teacherService;

    @Test
    public void shouldGetAllTeachers() throws Exception {
        TeacherDto fooBar = new TeacherDto(1, "Foo", "Bar", "Spring");
        TeacherDto johnDoe = new TeacherDto(2, "John", "Doe", "Spring");

        given(teacherService.findAll()).willReturn(new TeachersDto(Arrays.asList(fooBar, johnDoe)));

        mvc.perform(get("/api/teachers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.teachers", hasSize(2)))
                .andExpect(jsonPath("$.teachers[0].firstName", is(fooBar.getFirstName())))
                .andExpect(jsonPath("$.teachers[1].firstName", is(johnDoe.getFirstName())));
    }

    @Test
    public void shouldFindTeacherById() throws Exception {
        TeacherDto teacherDTO = new TeacherDto(1, "Foo", "Bar", "Spring");

        given(teacherService.findById(1)).willReturn(teacherDTO);

        mvc.perform(get("/api/teachers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(teacherDTO.getId())));
    }

    @Test
    public void shouldNotFindTeacherById() throws Exception {
        given(teacherService.findById(-22)).willThrow(new EntityNotFoundException("NotFound"));

        mvc.perform(get("/api/teachers/-22")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
